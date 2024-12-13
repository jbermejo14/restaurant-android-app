package com.example.restaurantapp.api;

import java.util.List;

import com.example.restaurantapp.domain.Customer;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CustomersApiInterface {

    @GET("customers")
    Call<List<Customer>> getCustomers();

    @POST("customers")
    Call<Customer> addCustomer(@Body Customer customer);

    @GET("customers/customerId")
    Call<Customer> getCustomer(@Path("id") String customerId);
}
