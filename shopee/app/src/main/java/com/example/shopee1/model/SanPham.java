package com.example.shopee1.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SanPham implements Parcelable {

    @SerializedName("Id")
    @Expose
    private Integer Id;
    @SerializedName("TenSp")
    @Expose
    private String TenSp;
    @SerializedName("GiaSp")
    @Expose
    private Integer GiaSp;
    @SerializedName("SoLuong")
    @Expose
    private Integer SoLuong;

    @SerializedName("Size")
    @Expose
    private String Size;
    @SerializedName("MoTa")
    @Expose
    private String MoTa;
    @SerializedName("HinhAnh")
    @Expose
    private String HinhAnh;

    @SerializedName("Loai")
    @Expose
    private String Loai;


    public SanPham(Integer id, String tenSp, Integer giaSp, Integer soLuong, String size, String moTa, String hinhAnh, String loai) {
        Id = id;
        TenSp = tenSp;
        GiaSp = giaSp;
        SoLuong = soLuong;
        Size = size;
        MoTa = moTa;
        HinhAnh = hinhAnh;
        Loai = loai;
    }

    protected SanPham(Parcel in) {
        if (in.readByte() == 0) {
            Id = null;
        } else {
            Id = in.readInt();
        }
        TenSp = in.readString();
        if (in.readByte() == 0) {
            GiaSp = null;
        } else {
            GiaSp = in.readInt();
        }
        if (in.readByte() == 0) {
            SoLuong = null;
        } else {
            SoLuong = in.readInt();
        }
        Size = in.readString();
        MoTa = in.readString();
        HinhAnh = in.readString();
        Loai = in.readString();
    }

    public static final Creator<SanPham> CREATOR = new Creator<SanPham>() {
        @Override
        public SanPham createFromParcel(Parcel in) {
            return new SanPham(in);
        }

        @Override
        public SanPham[] newArray(int size) {
            return new SanPham[size];
        }
    };

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getTenSp() {
        return TenSp;
    }

    public void setTenSp(String tenSp) {
        TenSp = tenSp;
    }

    public Integer getGiaSp() {
        return GiaSp;
    }

    public void setGiaSp(Integer giaSp) {
        GiaSp = giaSp;
    }

    public Integer getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(Integer soLuong) {
        SoLuong = soLuong;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        HinhAnh = hinhAnh;
    }

    public String getLoai() {
        return Loai;
    }

    public void setLoai(String loai) {
        Loai = loai;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (Id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(Id);
        }
        dest.writeString(TenSp);
        if (GiaSp == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(GiaSp);
        }
        if (SoLuong == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(SoLuong);
        }
        dest.writeString(Size);
        dest.writeString(MoTa);
        dest.writeString(HinhAnh);
        dest.writeString(Loai);
    }

}