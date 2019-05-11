package com.example.shopee1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.drawerlayout.widget.DrawerLayout;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.shopee1.Adapter.adapter_sanpham1;
import com.example.shopee1.model.SanPham;
import com.example.shopee1.retrofit2.APIUtils;
import com.example.shopee1.retrofit2.DataClient;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class ThucPhamNamActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mtoggle;
    NavigationView navigationView;
    View headerview; // khai báo headerview vì nó cx là 1 view

    ArrayList<SanPham> listspnam;
    adapter_sanpham1 adapter_sanphamnam;
    ListView lv;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thuc_pham_nam);

        anhxa();
        navigationviewclick();
        searchviewhihi();
        loadsanpham();
    }

    private void loadsanpham() {
        DataClient dataClient= APIUtils.getData();
        Call<List<SanPham>> callback=dataClient.loadspnam();
        callback.enqueue(new Callback<List<SanPham>>() {
            @Override
            public void onResponse(Call<List<SanPham>> call, Response<List<SanPham>> response) {
                ArrayList<SanPham> listsp = (ArrayList<SanPham>) response.body();
                listspnam.addAll(listsp);
                adapter_sanphamnam.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<SanPham>> call, Throwable t) {

            }
        });
    }




    private void searchviewhihi() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter_sanphamnam.getFilter().filter(newText);
                return false;
            }
        });
    }

    private void navigationviewclick() { // sự kiện click item trong navigation view
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setCheckable(true); // khi chọn sẽ giữ lại trạng thái chọn
                switch (menuItem.getItemId()){
                    case R.id.trangchu:
                        startActivity(new Intent(ThucPhamNamActivity.this,TrangChuActivity.class));
                        break;
                    case R.id.thucphamnu:
                        startActivity(new Intent(ThucPhamNamActivity.this,ThucPhamNuActivity.class));
                        break;
                    case R.id.thucphamnam:
                        break;

                    case R.id.giohang:
                        startActivity(new Intent(ThucPhamNamActivity.this,GioHangActivity.class));
                        break;
                    case R.id.lichsumuahang:
                        startActivity(new Intent(ThucPhamNamActivity.this,LichSuMuaHangActivity.class));
                        break;
                    case R.id.nhantin:
                        startActivity(new Intent(ThucPhamNamActivity.this,NhanTinActivity.class));
                        break;

                }
                return true;
            }
        });
        headerview = navigationView.getHeaderView(0); // bắt sự kiện cho header layout
        final TextView profilename = (TextView) headerview.findViewById(R.id.textView);
        final CircleImageView imghinh=(CircleImageView) headerview.findViewById(R.id.profile_image) ;
//        Picasso.with(this).load(listuser.get(0).getHinhanh()).into(imghinh);
//        profilename.setText(listuser.get(0).getTaikhoan());
        imghinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // chuyển qua màn profile
            }
        });

    }


    private void anhxa() {
        lv=findViewById(R.id.lvquanaonu);
        searchView=findViewById(R.id.searchview);
        listspnam=new ArrayList<>();

        adapter_sanphamnam=new adapter_sanpham1(listspnam,this);
        lv.setAdapter(adapter_sanphamnam);

        getSupportActionBar().hide();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.RED));
        navigationView = findViewById(R.id.navigation);
    }
}
