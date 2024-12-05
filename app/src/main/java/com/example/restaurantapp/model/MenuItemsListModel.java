package com.example.restaurantapp.model;

import com.example.restaurantapp.api.MenuItemsApi;
import com.example.restaurantapp.api.MenuItemsApiInterface;
import com.example.restaurantapp.contract.MenuItemListContract;
import com.example.restaurantapp.domain.MenuItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuItemsListModel implements MenuItemListContract.Model {

    @Override
    public void loadMenuItems(OnMenuItemLoadedListener listener) {
        MenuItemsApiInterface menuitemsApi = MenuItemsApi.buildInstance();
        Call<List<MenuItem>> getMenuItemsCall = menuitemsApi.getMenuItems();
        getMenuItemsCall.enqueue(new Callback<List<MenuItem>>() {
            @Override
            public void onResponse(Call<List<MenuItem>> call, Response<List<MenuItem>> response) {
                if (response.code() == 200) {
                    listener.onLoadMenuItemSuccess(response.body());
                } else if (response.code() == 500 ){
                    listener.onLoadMenuItemFailed("La API no se encuentra disponible en este momento. Prueba de nuevo");
                } else {
                    listener.onLoadMenuItemFailed(String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<MenuItem>> call, Throwable t) {
                listener.onLoadMenuItemFailed("No se puedo conectar con el origen de datos. " +
                        "Comprueba la conexión e inténtalo otra vez");
            }
        });
    }
}
