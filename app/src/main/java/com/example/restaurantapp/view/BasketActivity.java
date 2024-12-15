package com.example.restaurantapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.restaurantapp.MapActivity;
import com.example.restaurantapp.R;
import com.example.restaurantapp.adapter.BasketAdapter;
import com.example.restaurantapp.contract.RegisterOrderContract;
import com.example.restaurantapp.domain.Beverage;
import com.example.restaurantapp.domain.MenuItem;
import com.example.restaurantapp.domain.Order;
import com.example.restaurantapp.presenter.RegisterOrderPresenter;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BasketActivity extends AppCompatActivity implements RegisterOrderContract.View {
    double totalPrice = 0;
    private Button editButton;
    private RegisterOrderPresenter presenter;
    List<MenuItem> menuItems;
    List<Beverage> beverages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList<Parcelable> combinedList = getIntent().getParcelableArrayListExtra("combinedList");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basket_activity);;
        presenter = new RegisterOrderPresenter(this);

        RecyclerView recyclerView = findViewById(R.id.basket_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Separate into MenuItem and Beverage if needed
        menuItems = new ArrayList<>();
        beverages = new ArrayList<>();

        for (Parcelable item : combinedList) {
            if (item instanceof MenuItem) {
                menuItems.add((MenuItem) item);
                totalPrice = totalPrice + ((MenuItem) item).getPrice();
            } else if (item instanceof Beverage) {
                beverages.add((Beverage) item);
                totalPrice = totalPrice + ((Beverage) item).getPrice();
            }
        }
        Gson gson = new Gson();
        String beveragesJson = gson.toJson(beverages);
        Log.d("Order JSON bev", beveragesJson);

        String alljson = gson.toJson(combinedList);
        Log.d("Order JSON combi", alljson);

        String menuitemjson = gson.toJson(menuItems);
        Log.d("Order JSON menu", menuitemjson);

        TextView totalPriceTextView = findViewById(R.id.totalPrice); // make sure this ID exists in your XML
        totalPriceTextView.setText(String.valueOf(totalPrice));

        BasketAdapter basketAdapter = new BasketAdapter(combinedList);
        recyclerView.setAdapter(basketAdapter);

    }

    public void addOrder(View view) {
        try {
            Date orderDate = new Date();

            Order order = new Order(menuItems, beverages, orderDate, totalPrice);
            Gson gson = new Gson();
            String orderJson = gson.toJson(order);

            Log.d("Order JSON", orderJson);
            presenter.registerOrder(order);

        } catch (Exception e) {
            e.printStackTrace();
        }
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
        } else if (item.getItemId() == R.id.profile_button) {
            Intent intent = new Intent(this, EditCustomer.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.orders_button) {
            Intent intent = new Intent(this, BasketListView.class);
            startActivity(intent);
        }
        return true;
    }

    @Override
    public void showErrorMessage(String message) {
        Snackbar.make(findViewById(R.id.registerMeal), message, BaseTransientBottomBar.LENGTH_INDEFINITE).show();
    }

    @Override
    public void showSuccessMessage(String message) {
        Snackbar.make(findViewById(R.id.registerMeal), message, BaseTransientBottomBar.LENGTH_SHORT);
    }
}