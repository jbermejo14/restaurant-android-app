package com.example.restaurantapp.view;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.restaurantapp.R;


public class DetailRestaurantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_view_item);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        printRestaurant(name);
    }

    private void printRestaurant(String name) {
        ((TextView) findViewById(R.id.item_name)).setText(String.valueOf(name));
    }
}


