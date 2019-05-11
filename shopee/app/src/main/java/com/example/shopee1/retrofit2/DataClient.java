package com.example.shopee1.retrofit2;

import com.example.shopee1.model.ChiTietHoaDonBan;
import com.example.shopee1.model.HoaDonBan;
import com.example.shopee1.model.SanPham;
import com.example.shopee1.model.TaiKhoan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DataClient {
//    @FormUrlEncoded
//    @POST("api/login")
//    Call<ResponseBody> login(@FieldMap Map<String, String> params);

 // tải khoản nè
    @FormUrlEncoded
    @POST("api/login")
    Call<List<TaiKhoan>> login(@Field("tk") String tk, @Field("mk") String mk);

    @FormUrlEncoded
    @POST("api/dangki")
    Call<String> dangki(
            @Field("id") String id,
            @Field("tk") String tk,
            @Field("mk") String mk,
            @Field("sdt") String sdt,
            @Field("hoten") String hoten,
            @Field("diachi") String diachi,
            @Field("hinhanh") String hinhanh);
    // sản phẩm nè
//    @FormUrlEncoded
//    @POST("api/loadsptrangchu")
//    Call<List<SanPham>> loadsptt(@Field("key") String key);

// load về dùng get
   @GET("api/loadsptrangchu")
   Call<List<SanPham>> loadsptt1();

    @GET("api/loadspnu")
    Call<List<SanPham>> loadspnu();

    @GET("api/loadspnam")
    Call<List<SanPham>> loadspnam();
    // xử lý bán hàng
    // gửi thông tin lên để lập hóa đơn
    @FormUrlEncoded
    @POST("api/laphoadonban")
    Call<List<HoaDonBan>> laphoadon(@Field("idtk") Integer idtk,
                                    @Field("tongtien") Integer tongtien,
                                    @Field("hoten") String hoten,
                                    @Field("ngaylaphd") String ngaylaphd,
                                    @Field("dagiaohang") Integer dagiaohang);

    @FormUrlEncoded
    @POST("api/ghichitiethoadon")
    Call<List<ChiTietHoaDonBan>> ghichitiethoadon(@Field("idsp") Integer idsp,
                                                  @Field("idhoadon") Integer idhoadon,
                                                  @Field("soluong") Integer soluong,
                                                  @Field("dongia") Integer dongia,
                                                  @Field("thanhtien") Integer thanhtien,
                                                  @Field("tensp") String tensp,
                                                  @Field("hinhanh") String hinhanh);

    @FormUrlEncoded
    @POST("api/updatesoluongsanpham")
    Call<List<SanPham>> updatesoluongsanpham(@Field("idsp") Integer idsp,
                                                  @Field("soluong") Integer soluong);

    // đang giao hàng , đã giao hàng


    @FormUrlEncoded
    @POST("api/loadhoadondagiaohang")
    Call<List<HoaDonBan>> loadhoadondagiaohang(@Field("idtk") Integer idtk);

    @FormUrlEncoded
    @POST("api/loadhoadondanggiaohang")
    Call<List<HoaDonBan>> loadhoadondanggiaohang(@Field("idtk") Integer idtk);

    @FormUrlEncoded
    @POST("api/loadchitiethoadondanggiao")
    Call<List<ChiTietHoaDonBan>> loadchitiethoadon(@Field("idhoadon") Integer id);




}


// đối với upload dạng hình ảnh hay bất cứ thứ gì ngoài String hay số thì dùng multipart
//    @Multipart
//    @POST("http://192.168.1.14/test/api/uploadhinh.php") // gọi đến file php thực hiện chức năng này
//    Call<String> UploadPhoto(@Part MultipartBody.Part photo);
//
//    @FormUrlEncoded
//    @POST("http://192.168.1.14/test/api/insert.php")
//    Call<String> InsertData(
//            @Field("ten") String ten,
//            @Field("hinhanh") String hinhanh);
//    @FormUrlEncoded
//    @POST("loaddulieu.php")
//    Call<List<person>> loaddulieu(@Field("key") String key);
//
//
//    //    @GET("delete.php")
////    Call<String> xoadulieu(@Query("ten") String ten, // nối chuỗi vào đường link dưới phương thức của get
////                           @Query("hinhanh") String hinhanh);
//    @FormUrlEncoded
//    @POST("delete.php")
//    Call<String> xoadulieu(@Field("ten") String ten,
//                           @Field("hinhanh") String hinhanh);
//    @FormUrlEncoded
//    @POST("update.php")
//    Call<String> updatedulieu(@Field("ten") String ten,
//                              @Field("hinhanh") String hinhanh);
//
//    @FormUrlEncoded
//    @POST("timkiem.php")
//    Call<String> timkiem(@Field("ten") String ten);