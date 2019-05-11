package com.example.shopee1.Adapter;

import com.example.shopee1.Fragment.fragment_dagiaohang;
import com.example.shopee1.Fragment.fragment_danggiaohang;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class pagerAdapter_LSMH extends FragmentStatePagerAdapter {
    public pagerAdapter_LSMH(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
       Fragment fragment=null;
       switch (position){
           case 0: fragment=new fragment_danggiaohang();
           break;
           case 1: fragment=new fragment_dagiaohang();
           break;
       }
       return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title="đang giao hàng";
                break;
            case 1:
                title="đã mua hàng";
                break;

        }

        return title;
    }
}
