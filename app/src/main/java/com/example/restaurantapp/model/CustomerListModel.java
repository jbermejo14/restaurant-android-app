package com.example.restaurantapp.model;


import com.example.restaurantapp.api.CustomersApi;
import com.example.restaurantapp.api.CustomersApiInterface;
import com.example.restaurantapp.contract.CustomerListContract;
import com.example.restaurantapp.domain.Customer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomerListModel implements CustomerListContract.Model {

    @Override
    public void loadCustomers(OnCustomerLoadedListener listener) {
        CustomersApiInterface customersApi = CustomersApi.buildInstance();
        Call<List<Customer>> getCustomersCall = customersApi.getCustomers();
        getCustomersCall.enqueue(new Callback<List<Customer>>() {
            @Override
            public void onResponse(Call<List<Customer>> call, Response<List<Customer>> response) {
                if (response.code() == 200) {
                    listener.onLoadCustomerSuccess(response.body());
                } else if (response.code() == 500 ){
                    listener.onLoadCustomerFailed("La API no se encuentra disponible en este momento. Prueba de nuevo");
                } else {
                    listener.onLoadCustomerFailed(String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<Customer>> call, Throwable t) {
                listener.onLoadCustomerFailed("No se puedo conectar con el origen de datos. " +
                        "Comprueba la conexión e inténtalo otra vez");
            }
        });
    }
}
