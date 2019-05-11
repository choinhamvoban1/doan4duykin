package com.example.shopee1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.shopee1.Adapter.pagerAdapter_LSMH;
import com.google.android.material.tabs.TabLayout;

public class LichSuMuaHangActivity extends AppCompatActivity {
    private TabLayout tablayout;
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_su_mua_hang);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mViewPager = (ViewPager) findViewById(R.id.container);
        tablayout = (TabLayout) findViewById(R.id.tabs);
        FragmentManager manager=getSupportFragmentManager();
//FragmentManager manager=getChildFragmentManager();
        // hoặc như trên trong fragment
        pagerAdapter_LSMH adapter=new pagerAdapter_LSMH(manager); //khởi tạo adapter cho viewpager
        mViewPager.setAdapter(adapter);
        tablayout.setupWithViewPager(mViewPager);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));// lắng nghe sự kiện thay ddooir khi vuốt
        tablayout.setTabsFromPagerAdapter(adapter);  // set title cho tab
    }
}
