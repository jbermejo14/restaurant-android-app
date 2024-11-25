package com.example.restaurantapp.view;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.restaurantapp.R;
import com.example.restaurantapp.adapter.MenuItemAdapter;
import com.example.restaurantapp.domain.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class DetailRestaurantActivity extends AppCompatActivity {
    private MenuItemAdapter menuItemAdapter;
    private List<MenuItem> menuItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        Intent intent = getIntent();

        populateList();

        RecyclerView menuItemView = findViewById(R.id.menu_view);
        menuItemView.hasFixedSize();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        menuItemView.setLayoutManager(layoutManager);

        menuItemAdapter = new MenuItemAdapter(menuItemList);
        menuItemView.setAdapter(menuItemAdapter);
    }

    private void populateList() {
        menuItemList = new ArrayList<>();
        menuItemList.add(new MenuItem(1, "Curry con pollo", "afdadsf", 2.0, "arroces", false));
    }
}
