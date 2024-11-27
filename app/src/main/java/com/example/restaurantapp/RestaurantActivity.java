package com.example.restaurantapp;


import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.restaurantapp.adapter.RestaurantAdapter;
import com.example.restaurantapp.domain.Restaurant;
import android.view.MenuItem;
import android.view.Menu;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RestaurantActivity extends AppCompatActivity {
    private RestaurantAdapter restaurantAdapter;
    private List<Restaurant> restaurantList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_activity);

        populateList();

        RecyclerView restaurantView = findViewById(R.id.restaurant_view);
        restaurantView.hasFixedSize();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        restaurantView.setLayoutManager(layoutManager);

        restaurantAdapter = new RestaurantAdapter(restaurantList);
        restaurantView.setAdapter(restaurantAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NotNull android.view.MenuItem item) {
        if (item.getItemId() == R.id.action_map) {
            Intent intent = new Intent(this, RestaurantActivity.class);
            startActivity(intent);
        } else if (item.getItemId()  == R.id.action_register_customer) {
            Intent intent = new Intent(this, RestaurantActivity.class);
            startActivity(intent);
        }

        return true;
    }


    private void populateList() {
        restaurantList = new ArrayList<>();
        restaurantList.add(new Restaurant(1, "8 eat", "Calle San Jorge 45", "312341234", 53.807880, -1.775238));
        restaurantList.add(new Restaurant(2, "Burger madness", "Avenida Lilycroft 7", "312341234", 53.807880, -1.775238));
        restaurantList.add(new Restaurant(3, "Allue Pizzas", "Plaza Lopez Allue 1", "312341234", 53.807880, -1.775238));
    }

}
