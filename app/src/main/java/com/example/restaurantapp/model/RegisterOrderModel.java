package com.example.restaurantapp.model;
import android.util.Log;

import android.widget.Toast;
import com.example.restaurantapp.RegisterActivity;
import com.example.restaurantapp.api.OrdersApi;
import com.example.restaurantapp.api.OrdersApiInterface;
import com.example.restaurantapp.contract.RegisterOrderContract;
import com.example.restaurantapp.domain.Order;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterOrderModel implements RegisterOrderContract.Model {

    @Override
    public void registerOrder(Order order, OnRegisterOrderListener listener) {
        OrdersApiInterface ordersApi = OrdersApi.buildInstance();
        Call<Order> callRegisterOrder = ordersApi.addOrder(order);
        callRegisterOrder.enqueue(new Callback<Order>() {
            @Override
            public void onResponse(Call<Order> call, Response<Order> response) {
                if (response.isSuccessful() && response.code() == 201) {
                    Log.e("RegisterCustomerModel", "API call worked!!!!!!!!!");
                    listener.onRegisterOrderSuccess(response.body());
                } else if (response.code() == 400) {
                    Log.e("RegisterOrderModel", "API 400 errorrrrrrrr!");
                    listener.onRegisterOrderError("Validation error: " + response.message());
                } else if (response.code() == 500) {
                    Log.e("RegisterCustomerModel", "API 500 errorrrrrrrr!");
                    listener.onRegisterOrderError("Internal server error: " + response.message());
                } else {
                    Log.e("RegisterCustomerModel", "API other errorrrrrrrr!");
                    listener.onRegisterOrderError("Unexpected error: " + "Code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Order> call, Throwable t) {
                Log.e("RegisterOrderModel", "API call failed", t);
                listener.onRegisterOrderError("Connection error. Please try again.");
            }
        });
    }
}
