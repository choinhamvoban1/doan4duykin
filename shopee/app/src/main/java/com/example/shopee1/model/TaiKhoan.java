package com.example.shopee1.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TaiKhoan implements Parcelable {

    @SerializedName("Id")
    @Expose
    private Integer Id;
    @SerializedName("TaiKhoan")
    @Expose
    private String TaiKhoan;
    @SerializedName("MatKhau")
    @Expose
    private String MatKhau;
    @SerializedName("SDT")
    @Expose
    private String SDT;
    @SerializedName("DiaChi")
    @Expose
    private String DiaChi;
    @SerializedName("HoTen")
    @Expose
    private String HoTen;
    @SerializedName("HinhAnh")
    @Expose
    private String HinhAnh;

    public TaiKhoan(Integer id, String taiKhoan, String matKhau, String SDT, String diaChi, String hoTen, String hinhAnh) {
        Id = id;
        TaiKhoan = taiKhoan;
        MatKhau = matKhau;
        this.SDT = SDT;
        DiaChi = diaChi;
        HoTen = hoTen;
        HinhAnh = hinhAnh;
    }

    protected TaiKhoan(Parcel in) {
        if (in.readByte() == 0) {
            Id = null;
        } else {
            Id = in.readInt();
        }
        TaiKhoan = in.readString();
        MatKhau = in.readString();
        SDT = in.readString();
        DiaChi = in.readString();
        HoTen = in.readString();
        HinhAnh = in.readString();
    }

    public static final Creator<TaiKhoan> CREATOR = new Creator<TaiKhoan>() {
        @Override
        public TaiKhoan createFromParcel(Parcel in) {
            return new TaiKhoan(in);
        }

        @Override
        public TaiKhoan[] newArray(int size) {
            return new TaiKhoan[size];
        }
    };

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        TaiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        HinhAnh = hinhAnh;
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
        dest.writeString(TaiKhoan);
        dest.writeString(MatKhau);
        dest.writeString(SDT);
        dest.writeString(DiaChi);
        dest.writeString(HoTen);
        dest.writeString(HinhAnh);
    }
}
