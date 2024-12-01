package com.example.restaurantapp.view;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.restaurantapp.MapActivity;
import com.example.restaurantapp.R;
import com.example.restaurantapp.adapter.MenuItemAdapter;
import com.example.restaurantapp.domain.MenuItem;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class DetailRestaurantActivity extends AppCompatActivity {
    private MenuItemAdapter menuItemAdapter;
    private List<MenuItem> menuItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();

        populateList();

        RecyclerView menuItemView = findViewById(R.id.menu_view);
        menuItemView.hasFixedSize();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        menuItemView.setLayoutManager(layoutManager);

        menuItemAdapter = new MenuItemAdapter(menuItemList);
        menuItemView.setAdapter(menuItemAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NotNull android.view.MenuItem item) {
        if (item.getItemId() == R.id.action_map) {
            Intent intent = new Intent(this, MapActivity.class);
            startActivity(intent);
        } else if (item.getItemId()  == R.id.action_register_customer) {
            Intent intent = new Intent(this, RestaurantListView.class);
            startActivity(intent);
        }

        return true;
    }

    private void populateList() {
        menuItemList = new ArrayList<>();
        menuItemList.add(new MenuItem(1, "Curry con Pollo", "Arroz con salsa de curry con trozos de pollo con picante", 2.0, "arroces", false));
        menuItemList.add(new MenuItem(2, "Hamburgues de Queso", "hamburguesa de ternera con salsa queso chedar", 2.0, "arroces", false));
        menuItemList.add(new MenuItem(3, "Panini Italiano", "Panini con salsa roquefort y ternera", 2.0, "arroces", false));
        menuItemList.add(new MenuItem(4, "Arroz a la Cubana", "Arroz con salsa de tomate con huevo y platano frito", 2.0, "arroces", false));
        menuItemList.add(new MenuItem(5, "Salmon con Soja", "Salmon noruego con salsa de soja", 2.0, "arroces", false));
        menuItemList.add(new MenuItem(6, "Pizza 4 Quesos", "Clasica pizza de 4 quesos", 2.0, "arroces", false));



    }
}
