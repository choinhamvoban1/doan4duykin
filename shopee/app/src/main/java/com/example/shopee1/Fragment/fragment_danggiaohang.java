package com.example.shopee1.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.shopee1.Adapter.adapter_dangiaohang;
import com.example.shopee1.ChiTietHoaDonActivity;
import com.example.shopee1.R;
import com.example.shopee1.dbsqlite.Database;
import com.example.shopee1.model.ChiTietHoaDonBan;
import com.example.shopee1.model.HoaDonBan;
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

public class fragment_danggiaohang extends Fragment {
    ListView lv;
    ArrayList<TaiKhoan> listacc;
    ArrayList<HoaDonBan> listdanggiaohang;
    adapter_dangiaohang adapterDangiaohang;
    SQLiteDatabase database;

    ListView lvchitiethoadon;
    ArrayList<ChiTietHoaDonBan> listchitiethoadon;
    public fragment_danggiaohang() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_danggiaohang,container,false);
        database= Database.initDatabase((Activity) getContext(),"shopeeanthi.sqlite");
        lv=view.findViewById(R.id.lvdanggiaohang);
        listdanggiaohang=new ArrayList<>();
        listacc=new ArrayList<>();
        adapterDangiaohang=new adapter_dangiaohang(listdanggiaohang,getContext());
        lv.setAdapter(adapterDangiaohang);
         loadsanphamdanggiao();
         listviewclick();
        return view;
    }

    private void listviewclick() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getContext(), ChiTietHoaDonActivity.class);
                intent.putExtra("id",listdanggiaohang.get(position).getId());
                startActivity(intent);
            }
        });


    }

    private void loadsanphamdanggiao(){
        loadtaikhoan();
        DataClient dataClient= APIUtils.getData();
        Call<List<HoaDonBan>> callback=dataClient.loadhoadondanggiaohang(listacc.get(0).getId());
        callback.enqueue(new Callback<List<HoaDonBan>>() {
            @Override
            public void onResponse(Call<List<HoaDonBan>> call, Response<List<HoaDonBan>> response) {
                ArrayList<HoaDonBan>  list= (ArrayList<HoaDonBan>) response.body();
                listdanggiaohang.addAll(list);
                adapterDangiaohang.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<HoaDonBan>> call, Throwable t) {

            }
        });

    }

    private void loadtaikhoan() {
        Cursor cursor=database.rawQuery("select * from tk",null);
        while (cursor.moveToNext()){
            int id=cursor.getInt(0);
            String taikhoan=cursor.getString(1);
            String matkhau=cursor.getString(2);
            String sdt=cursor.getString(3);
            String diachi=cursor.getString(4);
            String hoten=cursor.getString(5);
            String hinhanh=cursor.getString(6);

            listacc.add(new TaiKhoan(id,taikhoan,matkhau,sdt,diachi,hoten,hinhanh));


        }
    }
}
