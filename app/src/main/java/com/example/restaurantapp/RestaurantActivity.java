package com.example.restaurantapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.restaurantapp.adapter.RestaurantAdapter;
import com.example.restaurantapp.domain.Restaurant;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RestaurantActivity extends AppCompatActivity {
    private RestaurantAdapter restaurantAdapter;
    private List<Restaurant> restaurantList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_activity);

        populateList();

        RecyclerView customerView = findViewById(R.id.customer_view);
        customerView.hasFixedSize();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        customerView.setLayoutManager(layoutManager);

        restaurantAdapter = new RestaurantAdapter(restaurantList);
        customerView.setAdapter(restaurantAdapter);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.action_bar, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onCreateItemSelected(@NotNull MenuItem item) {
//        if (item.getItemId() == R.id.action_map) {
//            Intent intent = new Intent(this, RegisterActivity.class);
//            startActivity(intent);
//        } else if (item.getItemId()  == R.id.action_register_customer) {
//            Intent intent = new Intent(this, RegisterActivity.class);
//            startActivity(intent);
//        }
//
//        return true;
//    }

    private void populateList() {
        restaurantList = new ArrayList<>();
        restaurantList.add(new Restaurant(1, "8 eat", "Calle San Jorge 45", "312341234", 53.807880, -1.775238));
    }

}
