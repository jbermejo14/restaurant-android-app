package com.example.restaurantapp.model;


import com.example.restaurantapp.api.RestaurantsApi;
import com.example.restaurantapp.api.RestaurantsApiInterface;
import com.example.restaurantapp.contract.RestaurantListContract;
import com.example.restaurantapp.domain.Restaurant;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestaurantListModel implements RestaurantListContract.Model {

    @Override
    public void loadCars(OnRestaurantLoadedListener listener) {
        RestaurantsApiInterface carsApi = RestaurantsApi.buildInstance();
        Call<List<Restaurant>> getCarsCall = carsApi.getRestaurants();
        getCarsCall.enqueue(new Callback<List<Restaurant>>() {
            @Override
            public void onResponse(Call<List<Restaurant>> call, Response<List<Restaurant>> response) {
                if (response.code() == 200) {
                    listener.onLoadRestaurantSuccess(response.body());
                } else if (response.code() == 500 ){
                    listener.onLoadRestaurantFailed("La API no se encuentra disponible en este momento. Prueba de nuevo");
                } else {
                    listener.onLoadRestaurantFailed(String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<Restaurant>> call, Throwable t) {
                listener.onLoadRestaurantFailed("No se puedo conectar con el origen de datos. " +
                        "Comprueba la conexión e inténtalo otra vez");
            }
        });
    }
}
