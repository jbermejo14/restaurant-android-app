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
import com.example.restaurantapp.contract.MenuItemListContract;
import com.example.restaurantapp.contract.RestaurantListContract;
import com.example.restaurantapp.domain.MenuItem;
import com.example.restaurantapp.domain.Restaurant;
import com.example.restaurantapp.presenter.MenuItemListPresenter;
import com.example.restaurantapp.presenter.RestaurantListPresenter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class MenuItemListView extends AppCompatActivity  implements MenuItemListContract.View {
    private MenuItemAdapter menuItemAdapter;
    private List<MenuItem> menuItemList;
    private MenuItemListContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        presenter = new MenuItemListPresenter(this);
        presenter.loadMenuItems();

        menuItemList = new ArrayList<>();

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

    @Override
    public void ListMenuItems(List<MenuItem> menuitemList) {
        this.menuItemList.addAll(menuitemList);
        menuItemAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    public void showSuccessMessage(String message) {

    }
}
