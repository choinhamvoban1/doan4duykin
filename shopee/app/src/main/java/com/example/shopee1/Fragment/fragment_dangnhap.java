package com.example.shopee1.Fragment;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shopee1.R;
import com.example.shopee1.TrangChuActivity;
import com.example.shopee1.dbsqlite.Database;
import com.example.shopee1.model.TaiKhoan;
import com.example.shopee1.retrofit2.APIUtils;
import com.example.shopee1.retrofit2.DataClient;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class fragment_dangnhap extends Fragment {
    EditText edttkdn,edtmkdn;
    CheckBox cb;

    SQLiteDatabase database;

    public fragment_dangnhap() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_dangnhap,container,false);
        Button btndangnhap=view.findViewById(R.id.btndangnhap);
        edttkdn=view.findViewById(R.id.edttk);
        edtmkdn=view.findViewById(R.id.edtmk);
        cb=view.findViewById(R.id.checkBox);
        database= Database.initDatabase(getActivity(),"shopeeanthi.sqlite");

        SharedPreferences sharedPreferences=getContext().getSharedPreferences("luumatkhau",MODE_PRIVATE);
        final SharedPreferences.Editor editor=sharedPreferences.edit();
        edttkdn.setText(""+sharedPreferences.getString("tk",""));
        edtmkdn.setText(""+sharedPreferences.getString("mk",""));
        cb.setChecked(sharedPreferences.getBoolean("luumk",false));




        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tk=edttkdn.getText().toString();
                 String mk=edtmkdn.getText().toString();
                DataClient dataClient= APIUtils.getData();
               Call<List<TaiKhoan>> callback=dataClient.login(tk,mk); // gọi POst login trong dataClient
               callback.enqueue(new Callback<List<TaiKhoan>>() {
                   @Override
                   public void onResponse(Call<List<TaiKhoan>> call, Response<List<TaiKhoan>> response) {
                       ArrayList<TaiKhoan> listtk= (ArrayList<TaiKhoan>) response.body(); // convert từ json thành arraylisst

                       if(listtk.size()<=0){ // nếu  ko có dữ liệu trả về
                           Toast.makeText(getContext(), "mk ko đúng   ", Toast.LENGTH_SHORT).show();

                       }else{
                           if(cb.isChecked()){
                               editor.putString("tk",edttkdn.getText().toString()); // lưu vào trong cache
                               editor.putString("mk",edtmkdn.getText().toString());
                               editor.putBoolean("luumk",true);
                               editor.commit();

                               ContentValues contentValues=new ContentValues(); // lưu vào sqlite
                               contentValues.put("id",listtk.get(0).getId());
                               contentValues.put("taikhoan", listtk.get(0).getTaiKhoan());
                               contentValues.put("matkhau", listtk.get(0).getMatKhau());
                               contentValues.put("sdt", listtk.get(0).getSDT());
                               contentValues.put("diachi", listtk.get(0).getDiaChi());
                               contentValues.put("hoten", listtk.get(0).getHoTen());
                               contentValues.put("hinhanh", listtk.get(0).getHinhAnh());

                               database.insert("tk",null,contentValues);
                               Intent intent=new Intent(getContext(),TrangChuActivity.class); // chuyển qua trang chủ

                               startActivity(intent);
                           }else{
                               editor.remove("tk");
                               editor.remove("mk");
                               editor.remove("luumk");
                               editor.apply();

                               ContentValues contentValues=new ContentValues();
                               contentValues.put("id",listtk.get(0).getId());
                               contentValues.put("taikhoan", listtk.get(0).getTaiKhoan());
                               contentValues.put("matkhau", listtk.get(0).getMatKhau());
                               contentValues.put("sdt", listtk.get(0).getSDT());
                               contentValues.put("diachi", listtk.get(0).getDiaChi());
                               contentValues.put("hoten", listtk.get(0).getHoTen());
                               contentValues.put("hinhanh", listtk.get(0).getHinhAnh());
                               database.insert("tk",null,contentValues);
                               Intent intent=new Intent(getContext(),TrangChuActivity.class);

                               startActivity(intent);
                           }



                       }


                   }

                   @Override
                   public void onFailure(Call<List<TaiKhoan>> call, Throwable t) {

                   }
               });
            }
        });

       return view;
    }
}
