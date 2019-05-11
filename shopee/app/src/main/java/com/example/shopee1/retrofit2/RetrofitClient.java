package com.example.shopee1.retrofit2;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit=null; // khai báo biến
    public  static Retrofit getClient(String baseurl){  // để sử dụng cần 1 đường dẫn truyền vào
        OkHttpClient builder=new OkHttpClient.Builder() // sử dụng thư viện okhttp
                .readTimeout(10000,TimeUnit.MILLISECONDS) // set thời gian ngắt đọc dữ liệu từ server
                . writeTimeout(10000,TimeUnit.MILLISECONDS) // set thời gian ngắt khi viết vào server
                .connectTimeout(10000,TimeUnit.MILLISECONDS) // thời gian kết nối đến server
                .retryOnConnectionFailure(true) // khôi phục kết nối thử lại xem có kết nối được ko
                .build();
        Gson gson=new GsonBuilder().setLenient().create();

        retrofit=new Retrofit.Builder()
                .baseUrl(baseurl)
                .client(builder)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return  retrofit;
    }
}
