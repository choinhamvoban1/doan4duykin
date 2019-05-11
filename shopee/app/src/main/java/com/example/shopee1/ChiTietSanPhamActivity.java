package com.example.shopee1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shopee1.model.SanPham;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ChiTietSanPhamActivity extends AppCompatActivity {
     TextView txttensp,txtgiasp,txtsize,txtsoluong,txtmota;
     ImageView imghinhsp;
     ArrayList<SanPham> listsp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_san_pham);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        anhxa();
        Intent intent=getIntent();
        String hinhanh=intent.getStringExtra("hinhanh");
        String tensp=intent.getStringExtra("tensp");
        int giasp=intent.getIntExtra("giasp",0);
        String mota=intent.getStringExtra("mota");
        String size=intent.getStringExtra("size");
        int soluong=intent.getIntExtra("soluong",0);

        Picasso.with(this).load(""+hinhanh).into(imghinhsp);
        txttensp.setText(""+tensp);
        txtgiasp.setText(""+giasp);
        txtsize.setText(""+size);
        txtsoluong.setText(""+soluong);
        txtmota.setText(""+mota);

    }

    private void anhxa() {
        txttensp=findViewById(R.id.txttenspCT);
        txtgiasp=findViewById(R.id.giaspCT);
        txtsize=findViewById(R.id.txtsizeCT);
        txtsoluong=findViewById(R.id.txtsoluongCT);
        txtmota=findViewById(R.id.txtmotaCT);
        imghinhsp=findViewById(R.id.imghinhspCT);
        listsp=new ArrayList<>();
    }
}
