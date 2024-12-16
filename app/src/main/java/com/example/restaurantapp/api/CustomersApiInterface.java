package com.example.restaurantapp.api;

import java.util.List;

import com.example.restaurantapp.domain.Customer;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface CustomersApiInterface {

    @GET("customers")
    Call<List<Customer>> getCustomers();

    @POST("customers")
    Call<Customer> addCustomer(@Body Customer customer);

    @GET("customers/{customerId}")
    Call<Customer> getCustomer(@Path("customerId") int customerId);

    @PUT("customers/{customerId}")
    Call<Void> updateCustomer(@Path("customerId") long id, @Body Customer customer);
}
