package com.example.shopee1;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.shopee1.Adapter.adapter_chitiethoadon;
import com.example.shopee1.model.ChiTietHoaDonBan;
import com.example.shopee1.retrofit2.APIUtils;
import com.example.shopee1.retrofit2.DataClient;

import java.util.ArrayList;
import java.util.List;

public class ChiTietHoaDonActivity extends AppCompatActivity {
ArrayList<ChiTietHoaDonBan> listhoadonban;
ListView lv;
adapter_chitiethoadon adapterChitiethoadon;
int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_hoa_don);
        Intent intent=getIntent();
        id=intent.getIntExtra("id",0);
        anhxa();
        loadhoadonban();
    }

    private void loadhoadonban() {
        DataClient dataClient= APIUtils.getData();
        Call<List<ChiTietHoaDonBan>> callback=dataClient.loadchitiethoadon(id);
        callback.enqueue(new Callback<List<ChiTietHoaDonBan>>() {
            @Override
            public void onResponse(Call<List<ChiTietHoaDonBan>> call, Response<List<ChiTietHoaDonBan>> response) {
                ArrayList<ChiTietHoaDonBan> listhdb= (ArrayList<ChiTietHoaDonBan>) response.body();
                listhoadonban.addAll(listhdb);
                adapterChitiethoadon.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<ChiTietHoaDonBan>> call, Throwable t) {

            }
        });
    }

    private void anhxa() {
        lv=findViewById(R.id.lvchitiet);
        listhoadonban=new ArrayList<>();
        adapterChitiethoadon=new adapter_chitiethoadon(listhoadonban,this);
        lv.setAdapter(adapterChitiethoadon);

    }
}
