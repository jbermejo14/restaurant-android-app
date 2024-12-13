package com.example.restaurantapp.model;

import com.example.restaurantapp.api.CustomersApiInterface;
import com.example.restaurantapp.contract.CustomerRoleContract;
import com.example.restaurantapp.domain.Customer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomerRoleModel implements CustomerRoleContract.Model {

    private CustomersApiInterface apiService; // Use your API service interface

    public CustomerRoleModel(CustomersApiInterface apiService) {
        this.apiService = apiService;
    }

    @Override
    public void fetchCustomer(String userId, CustomerRoleContract.Model.CustomerListener listener) {
        apiService.getCustomer(userId).enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(Call<Customer> call, Response<Customer> response) {
                if (response.isSuccessful() && response.body() != null) {
                    listener.onCustomerLoaded(response.body());
                } else {
                    listener.onError("Failed to load user details");
                }
            }

            @Override
            public void onFailure(Call<Customer> call, Throwable t) {
                listener.onError("An error occurred: " + t.getMessage());
            }
        });
    }
}
