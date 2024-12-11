package com.example.restaurantapp.model;

import com.example.restaurantapp.api.BeveragesApi;
import com.example.restaurantapp.api.BeveragesApiInterface;
import com.example.restaurantapp.contract.BeverageListContract;
import com.example.restaurantapp.domain.Beverage;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BeverageListModel implements BeverageListContract.Model {

    @Override
    public void loadBeverages(OnBeverageLoadedListener listener) {
        BeveragesApiInterface beveragesApi = BeveragesApi.buildInstance();
        Call<List<Beverage>> getBeverageCall = beveragesApi.getBeverages();
        getBeverageCall.enqueue(new Callback<List<Beverage>>() {
            @Override
            public void onResponse(Call<List<Beverage>> call, Response<List<Beverage>> response) {
                if (response.code() == 200) {
                    listener.onLoadBeverageSuccess(response.body());
                } else if (response.code() == 500 ){
                    listener.onLoadBeverageFailed("La API no se encuentra disponible en este momento. Prueba de nuevo");
                } else {
                    listener.onLoadBeverageFailed(String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<Beverage>> call, Throwable t) {
                listener.onLoadBeverageFailed("No se puedo conectar con el origen de datos. " +
                        "Comprueba la conexión e inténtalo otra vez");
            }
        });
    }
}
