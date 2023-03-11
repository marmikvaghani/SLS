package com.example.loginactivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAPI {
    private static RetrofitAPI instance = null;
    private  Api myApi;

    private RetrofitAPI() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okclient = new OkHttpClient.Builder()
                .addInterceptor(logging)
                 .connectTimeout(1, TimeUnit.MINUTES)
                 .readTimeout(30, TimeUnit.SECONDS)
                 .writeTimeout(15, TimeUnit.SECONDS)
                .build();

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .setLenient()
                .create();      

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okclient)
                .build();
        myApi = retrofit.create(Api.class);

    }
    public static synchronized RetrofitAPI getInstance() {
        if (instance == null) {
            instance = new RetrofitAPI();
        }
        return instance;
    }
    public Api getMyApi() {
        return myApi;
    }

}