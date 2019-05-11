package com.example.shopee1.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shopee1.R;
import com.example.shopee1.retrofit2.APIUtils;
import com.example.shopee1.retrofit2.DataClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment_dangki  extends Fragment {
    EditText edttk,edtmk,edtnlmk,edtsdt,edthoten,edtdiachi;
    Button btndangki;
    public fragment_dangki() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_dangki,container,false);
         edttk=view.findViewById(R.id.tk);
        edtmk=view.findViewById(R.id.mk);
        edtnlmk=view.findViewById(R.id.nlmk);
        edtsdt=view.findViewById(R.id.sdt);
        edthoten=view.findViewById(R.id.hoten);
        edtdiachi=view.findViewById(R.id.diachi);
        btndangki=view.findViewById(R.id.dangkitaikhoan);
        btndangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tk=edttk.getText().toString();
                String mk=edtmk.getText().toString();
                String nlmk=edtnlmk.getText().toString();
                String sdt=edtsdt.getText().toString();
                String hoten=edthoten.getText().toString();
                String diachi=edtdiachi.getText().toString();
                if(tk.isEmpty()||mk.isEmpty()||nlmk.isEmpty()||sdt.isEmpty()||hoten.isEmpty()||diachi.isEmpty()){
                    Toast.makeText(getContext(), "vui lòng điền đầy đủ thông tin ", Toast.LENGTH_SHORT).show();
                }else{
                    if(mk.equals(nlmk)){
                        DataClient dataClient= APIUtils.getData();
                        Call<String> callback=dataClient.dangki("",tk,mk,sdt,hoten,diachi,"");
                        callback.enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {
                                Toast.makeText(getContext(), "ok", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {
                                Toast.makeText(getContext(), "đăng kí thành công", Toast.LENGTH_SHORT).show();
                                edttk.setText("");
                                edtmk.setText("");
                                edtdiachi.setText("");
                                edtnlmk.setText("");
                                edthoten.setText("");

                            }
                        });

                    }else{
                        Toast.makeText(getContext(), "mật khẩu 2 dòng phải giống nhau ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        return view;
    }
}
