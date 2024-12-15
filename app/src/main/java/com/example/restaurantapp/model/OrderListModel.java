package com.example.restaurantapp.model;


import com.example.restaurantapp.api.OrdersApi;
import com.example.restaurantapp.api.OrdersApiInterface;
import com.example.restaurantapp.contract.OrderListContract;
import com.example.restaurantapp.domain.Order;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderListModel implements OrderListContract.Model {

    @Override
    public void loadOrders(OnOrderLoadedListener listener) {
        OrdersApiInterface ordersApi = OrdersApi.buildInstance();
        Call<List<Order>> getOrdersCall = ordersApi.getOrders();
        getOrdersCall.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                if (response.code() == 200) {
                    listener.onLoadOrderSuccess(response.body());
                } else if (response.code() == 500 ){
                    listener.onLoadOrderFailed("La API no se encuentra disponible en este momento. Prueba de nuevo");
                } else {
                    listener.onLoadOrderFailed(String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {
                listener.onLoadOrderFailed("No se puedo conectar con el origen de datos. " +
                        "Comprueba la conexión e inténtalo otra vez");
            }
        });
    }
}
