package com.example.shopee1.retrofit2;
public class APIUtils {
    public  static final String Base_Url="http://433b8407.ngrok.io/";
    public static DataClient getData(){
        return RetrofitClient.getClient(Base_Url).create(DataClient.class);
    }
}