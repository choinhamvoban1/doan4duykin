package com.example.shopee1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DonViNhap {

    @SerializedName("Id")
    @Expose
    private Integer Id;
    @SerializedName("TenDV")
    @Expose
    private String TenDV;
    @SerializedName("DiaChi")
    @Expose
    private String DiaChi;

    public DonViNhap(Integer id, String tenDV, String diaChi) {
        Id = id;
        TenDV = tenDV;
        DiaChi = diaChi;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getTenDV() {
        return TenDV;
    }

    public void setTenDV(String tenDV) {
        TenDV = tenDV;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }
}