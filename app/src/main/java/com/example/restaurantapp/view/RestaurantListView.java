package com.example.restaurantapp.view;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.restaurantapp.R;
import com.example.restaurantapp.adapter.RestaurantAdapter;
import com.example.restaurantapp.domain.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantListView extends AppCompatActivity {
    private RestaurantAdapter restaurantAdapter;
    private List<Restaurant> restaurantList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_activity);

        populateList();
//        RestaurantsApiInterface restaurantsApi = RestaurantsApi.buildInstance();
//        restaurantList = restaurantsApi.getRestaurants().body()

        RecyclerView restaurantView = findViewById(R.id.restaurant_view);
        restaurantView.hasFixedSize();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        restaurantView.setLayoutManager(layoutManager);

        restaurantAdapter = new RestaurantAdapter(restaurantList);
        restaurantView.setAdapter(restaurantAdapter);
    }

    private void populateList() {
        restaurantList = new ArrayList<>();
        restaurantList.add(new Restaurant(1, "8 eat", "Calle San Jorge 45", "312341234", 53.807880, -1.775238));
        restaurantList.add(new Restaurant(2, "Burger madness", "Avenida Lilycroft 7", "312341234", 53.807880, -1.775238));
        restaurantList.add(new Restaurant(3, "Allue Pizzas", "Plaza Lopez Allue 1", "312341234", 53.807880, -1.775238));
    }

}
