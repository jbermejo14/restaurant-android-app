package com.example.restaurantapp.api;

import java.util.List;

import com.example.restaurantapp.domain.MenuItem;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MenuItemsApiInterface {

    @GET("menuitems")
    Call<List<MenuItem>> getMenuItems();

    @POST("menuitems")
    Call<MenuItem> addMenuItem(@Path("id") int id, @Body MenuItem menuitem);
}
