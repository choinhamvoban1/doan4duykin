package com.example.shopee1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HoaDonNhap {

    @SerializedName("Id")
    @Expose
    private Integer Id;
    @SerializedName("IdDonViNhap")
    @Expose
    private Integer IdDonViNhap;
    @SerializedName("TongTien")
    @Expose
    private Integer TongTien;
    @SerializedName("TenDV")
    @Expose
    private String TenDV;
    @SerializedName("NgayLapHd")
    @Expose
    private String NgayLapHd;

    @SerializedName("DangGiaoHang")
    @Expose
    private Integer DangGiaoHang;

    public HoaDonNhap(Integer id, Integer idDonViNhap, Integer tongTien, String tenDV, String ngayLapHd, Integer dangGiaoHang) {
        Id = id;
        IdDonViNhap = idDonViNhap;
        TongTien = tongTien;
        TenDV = tenDV;
        NgayLapHd = ngayLapHd;
        DangGiaoHang = dangGiaoHang;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getIdDonViNhap() {
        return IdDonViNhap;
    }

    public void setIdDonViNhap(Integer idDonViNhap) {
        IdDonViNhap = idDonViNhap;
    }

    public Integer getTongTien() {
        return TongTien;
    }

    public void setTongTien(Integer tongTien) {
        TongTien = tongTien;
    }

    public String getTenDV() {
        return TenDV;
    }

    public void setTenDV(String tenDV) {
        TenDV = tenDV;
    }

    public String getNgayLapHd() {
        return NgayLapHd;
    }

    public void setNgayLapHd(String ngayLapHd) {
        NgayLapHd = ngayLapHd;
    }

    public Integer getDangGiaoHang() {
        return DangGiaoHang;
    }

    public void setDangGiaoHang(Integer dangGiaoHang) {
        DangGiaoHang = dangGiaoHang;
    }
}