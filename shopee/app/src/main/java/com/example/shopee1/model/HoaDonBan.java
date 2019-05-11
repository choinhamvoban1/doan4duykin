package com.example.shopee1.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HoaDonBan {

    @SerializedName("Id")
    @Expose
    private Integer id;

    @SerializedName("IdTaiKhoan")
    @Expose
    private Integer IdTaiKhoan;

    @SerializedName("TongTien")
    @Expose
    private Integer TongTien;

    @SerializedName("HoTen")
    @Expose
    private String HoTen;

    @SerializedName("NgayLapHd")
    @Expose
    private String NgayLapHd;

    @SerializedName("DaGiaoHang")
    @Expose
    private Integer DaGiaoHang;

    public HoaDonBan(Integer id, Integer idTaiKhoan, Integer tongTien, String hoTen, String ngayLapHd, Integer daGiaoHang) {
        this.id = id;
        IdTaiKhoan = idTaiKhoan;
        TongTien = tongTien;
        HoTen = hoTen;
        NgayLapHd = ngayLapHd;
        DaGiaoHang = daGiaoHang;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdTaiKhoan() {
        return IdTaiKhoan;
    }

    public void setIdTaiKhoan(Integer idTaiKhoan) {
        IdTaiKhoan = idTaiKhoan;
    }

    public Integer getTongTien() {
        return TongTien;
    }

    public void setTongTien(Integer tongTien) {
        TongTien = tongTien;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getNgayLapHd() {
        return NgayLapHd;
    }

    public void setNgayLapHd(String ngayLapHd) {
        NgayLapHd = ngayLapHd;
    }

    public Integer getDaGiaoHang() {
        return DaGiaoHang;
    }

    public void setDaGiaoHang(Integer daGiaoHang) {
        DaGiaoHang = daGiaoHang;
    }
}