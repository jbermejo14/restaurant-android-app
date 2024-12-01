package com.example.restaurantapp.api;

import java.util.List;

import com.example.restaurantapp.domain.Restaurant;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RestaurantsApiInterface {

    @GET("restaurnts")
    Call<List<Restaurant>> getRestaurants();

    @POST("users/{id}/restaurants")
    Call<Restaurant> addRestaurant(@Path("id") int id, @Body Restaurant car);
}
