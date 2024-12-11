package com.example.restaurantapp.api;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BeveragesApi {
    public static BeveragesApiInterface buildInstance() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.135:8080/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(BeveragesApiInterface.class);
    }
}

