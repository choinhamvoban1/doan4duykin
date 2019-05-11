package com.example.shopee1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuangCao {

    @SerializedName("Id")
    @Expose
    private Integer Id;
    @SerializedName("HinhAnh")
    @Expose
    private String HinhAnh;
    @SerializedName("IdSanPham")
    @Expose
    private Integer IdSanPham;

    public QuangCao(Integer id, String hinhAnh, Integer idSanPham) {
        Id = id;
        HinhAnh = hinhAnh;
        IdSanPham = idSanPham;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        HinhAnh = hinhAnh;
    }

    public Integer getIdSanPham() {
        return IdSanPham;
    }

    public void setIdSanPham(Integer idSanPham) {
        IdSanPham = idSanPham;
    }
}
