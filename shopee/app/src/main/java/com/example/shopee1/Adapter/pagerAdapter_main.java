package com.example.shopee1.Adapter;

import com.example.shopee1.Fragment.fragment_dangki;
import com.example.shopee1.Fragment.fragment_dangnhap;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class pagerAdapter_main extends FragmentStatePagerAdapter {
    public pagerAdapter_main(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        switch (position){
            case 0: fragment=new fragment_dangnhap();
                break;
            case 1: fragment=new fragment_dangki();
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
                title="đăng nhập";
                break;
            case 1:
                title="đăng kí";
                break;

        }

        return title;
    }
}
