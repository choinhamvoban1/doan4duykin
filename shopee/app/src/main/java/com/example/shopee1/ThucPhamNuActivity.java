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
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.shopee1.Adapter.adapter_SanPhamNu;
import com.example.shopee1.model.SanPham;
import com.example.shopee1.retrofit2.APIUtils;
import com.example.shopee1.retrofit2.DataClient;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class ThucPhamNuActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mtoggle;
    NavigationView navigationView;
    View headerview; // khai báo headerview vì nó cx là 1 view
    ArrayList<SanPham> listspnu;
    adapter_SanPhamNu adapter_sanphamnu;
    ListView lv;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thuc_pham_nu);
        anhxa();
        navigationviewclick();
        searchviewhihi();
        loadsanpham();
    }
    private void loadsanpham() {
        DataClient dataClient= APIUtils.getData();
        Call<List<SanPham>> callback=dataClient.loadspnu();
        callback.enqueue(new Callback<List<SanPham>>() {
            @Override
            public void onResponse(Call<List<SanPham>> call, Response<List<SanPham>> response) {
                ArrayList<SanPham> listsp = (ArrayList<SanPham>) response.body();
                listspnu.addAll(listsp);
                adapter_sanphamnu.notifyDataSetChanged();
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
                adapter_sanphamnu.getFilter().filter(newText);
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
                        startActivity(new Intent(ThucPhamNuActivity.this,TrangChuActivity.class));

                        break;
                    case R.id.thucphamnu:


                        break;
                    case R.id.thucphamnam:
                        startActivity(new Intent(ThucPhamNuActivity.this,ThucPhamNamActivity.class));

                        break;
                    case R.id.giohang:
                        startActivity(new Intent(ThucPhamNuActivity.this,GioHangActivity.class));

                        break;
                    case R.id.lichsumuahang:
                        startActivity(new Intent(ThucPhamNuActivity.this,LichSuMuaHangActivity.class));

                        break;
                    case R.id.nhantin:
                        startActivity(new Intent(ThucPhamNuActivity.this,NhanTinActivity.class));
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
        lv=findViewById(R.id.lvquanaonam);
        searchView=findViewById(R.id.searchview);
        listspnu=new ArrayList<>();

        adapter_sanphamnu=new adapter_SanPhamNu(listspnu,this);
        lv.setAdapter(adapter_sanphamnu);
//        listuser=new ArrayList<>();
//        Intent intent=getIntent();
//        listuser=intent.getParcelableArrayListExtra("manguser");
//        mDrawerLayout = findViewById(R.id.drawer_layout);
//        mtoggle = new ActionBarDrawerToggle(TrangChuActivity.this, mDrawerLayout, R.string.open, R.string.close);
//        mDrawerLayout.addDrawerListener(mtoggle);
//        mtoggle.syncState(); // tạo nút 3 gạch
        getSupportActionBar().hide(); // set title cho menu chính
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView = findViewById(R.id.navigation);
    }
}
