package com.example.restaurantapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.restaurantapp.MapActivity;
import com.example.restaurantapp.R;
import com.example.restaurantapp.adapter.BasketAdapter;
import com.example.restaurantapp.adapter.RestaurantAdapter;
import com.example.restaurantapp.contract.RestaurantListContract;
import com.example.restaurantapp.domain.BasketItem;
import com.example.restaurantapp.domain.Beverage;
import com.example.restaurantapp.domain.MenuItem;
import com.example.restaurantapp.domain.Restaurant;
import com.example.restaurantapp.presenter.RestaurantListPresenter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class BasketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basket_activity);

        RecyclerView recyclerView = findViewById(R.id.basket_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Get the combined list from the Intent
        ArrayList<Parcelable> combinedList = getIntent().getParcelableArrayListExtra("combinedList");

        // Separate into MenuItem and Beverage if needed
        List<MenuItem> menuItems = new ArrayList<>();
        List<Beverage> beverages = new ArrayList<>();
        for (Parcelable item : combinedList) {
            if (item instanceof MenuItem) {
                menuItems.add((MenuItem) item);
            } else if (item instanceof Beverage) {
                beverages.add((Beverage) item);
            }
        }

        // Set up the adapter (customize it to handle mixed data if required)
        BasketAdapter basketAdapter = new BasketAdapter(combinedList);
        recyclerView.setAdapter(basketAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        if (item.getItemId() == R.id.action_map) {
            Intent intent = new Intent(this, MapActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.action_register_customer) {
            Intent intent = new Intent(this, RestaurantListView.class);
            startActivity(intent);
        }
        return true;
    }

}
