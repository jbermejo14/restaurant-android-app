package com.example.restaurantapp.model;

import com.example.restaurantapp.api.CustomersApi;
import com.example.restaurantapp.api.CustomersApiInterface;
import com.example.restaurantapp.contract.RegisterCustomerContract;
import com.example.restaurantapp.domain.Customer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterCarModel implements RegisterCustomerContract.Model {

    @Override
    public void registerCar(Car car, OnRegisterCarListener listener) {
        CustomersApiInterface carsApi = CustomersApi.buildInstance();
        Call<Car> callRegisterCar = carsApi.addCar(1, car);
        callRegisterCar.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<Car> call, Response<Car> response) {
                switch (response.code()) {
                    case 201:
                        listener.onRegisterCarSuccess(response.body());
                        break;
                    case 400:
                        listener.onRegisterCarError("Error validando la petición: " + response.message());
                        break;
                    case 500:
                        listener.onRegisterCarError("Error interno en la API: " + response.message());
                        break;
                    default:
                        listener.onRegisterCarError("Error invocando a la API: " + response.message());
                        break;
                }
            }

            @Override
            public void onFailure(Call<Car> call, Throwable t) {
                listener.onRegisterCarError("No se puedo conectar con el origen de datos. " +
                        "Comprueba la conexión e inténtalo otra vez");
            }
        });
    }
}
