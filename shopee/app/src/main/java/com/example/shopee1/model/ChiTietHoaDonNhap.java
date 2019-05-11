package com.example.shopee1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChiTietHoaDonNhap {

    @SerializedName("Id")
    @Expose
    private Integer Id;
    @SerializedName("IdHoaDonNhap")
    @Expose
    private Integer IdHoaDonNhap;
    @SerializedName("IdSanPham")
    @Expose
    private Integer IdSanPham;
    @SerializedName("SoLuong")
    @Expose
    private Integer SoLuong;
    @SerializedName("DonGia")
    @Expose
    private Integer DonGia;
    @SerializedName("ThanhTien")
    @Expose
    private Integer ThanhTien;

    public ChiTietHoaDonNhap(Integer id, Integer idHoaDonNhap, Integer idSanPham, Integer soLuong, Integer donGia, Integer thanhTien) {
        Id = id;
        IdHoaDonNhap = idHoaDonNhap;
        IdSanPham = idSanPham;
        SoLuong = soLuong;
        DonGia = donGia;
        ThanhTien = thanhTien;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getIdHoaDonNhap() {
        return IdHoaDonNhap;
    }

    public void setIdHoaDonNhap(Integer idHoaDonNhap) {
        IdHoaDonNhap = idHoaDonNhap;
    }

    public Integer getIdSanPham() {
        return IdSanPham;
    }

    public void setIdSanPham(Integer idSanPham) {
        IdSanPham = idSanPham;
    }

    public Integer getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(Integer soLuong) {
        SoLuong = soLuong;
    }

    public Integer getDonGia() {
        return DonGia;
    }

    public void setDonGia(Integer donGia) {
        DonGia = donGia;
    }

    public Integer getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(Integer thanhTien) {
        ThanhTien = thanhTien;
    }
}