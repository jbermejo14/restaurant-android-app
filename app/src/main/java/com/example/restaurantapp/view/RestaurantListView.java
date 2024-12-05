package com.example.restaurantapp.view;


import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.restaurantapp.R;
import com.example.restaurantapp.adapter.RestaurantAdapter;
import com.example.restaurantapp.contract.RestaurantListContract;
import com.example.restaurantapp.domain.Restaurant;
import com.example.restaurantapp.presenter.RestaurantListPresenter;

import java.util.ArrayList;
import java.util.List;

public class RestaurantListView extends AppCompatActivity implements RestaurantListContract.View{
    private RestaurantAdapter restaurantAdapter;
    private List<Restaurant> restaurantList;
    private RestaurantListContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_activity);

        presenter = new RestaurantListPresenter(this);
        presenter.loadRestaurants();

        restaurantList = new ArrayList<>();

        RecyclerView restaurantView = findViewById(R.id.restaurant_view);
        restaurantView.hasFixedSize();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        restaurantView.setLayoutManager(layoutManager);

        restaurantAdapter = new RestaurantAdapter(restaurantList);
        restaurantView.setAdapter(restaurantAdapter);
    }

    @Override
    public void ListRestaurants(List<Restaurant> restaurantList) {
        this.restaurantList.addAll(restaurantList);
        restaurantAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showSuccessMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
