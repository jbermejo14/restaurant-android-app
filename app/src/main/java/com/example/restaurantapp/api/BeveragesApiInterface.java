package com.example.restaurantapp.api;

import java.util.List;

import com.example.restaurantapp.domain.Beverage;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BeveragesApiInterface {

    @GET("beverages")
    Call<List<Beverage>> getBeverages();

    @POST("beverages")
    Call<Beverage> addBeverage(@Path("id") int id, @Body Beverage menuitem);
}
