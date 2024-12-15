package com.example.restaurantapp.api;

import com.example.restaurantapp.domain.Order;
import com.example.restaurantapp.domain.Restaurant;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface OrdersApiInterface {
    @GET("orders")
    Call<List<Order>> getOrders();

    @POST("orders")
    Call<Order> addOrder(@Body Order order);
}