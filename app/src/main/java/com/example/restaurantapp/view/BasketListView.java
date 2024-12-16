package com.example.restaurantapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.restaurantapp.MapActivity;
import com.example.restaurantapp.R;
import com.example.restaurantapp.adapter.OrderAdapter;
import com.example.restaurantapp.contract.OrderListContract;
import com.example.restaurantapp.domain.Order;
import com.example.restaurantapp.presenter.OrderListPresenter;

import java.util.ArrayList;
import java.util.List;

public class BasketListView extends AppCompatActivity implements OrderListContract.View{
    private OrderAdapter orderAdapter;
    private List<Order> orderList;
    private OrderListContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_list_activity);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        presenter = new OrderListPresenter(this);
        presenter.loadOrders();

        orderList = new ArrayList<>();

        RecyclerView orderView = findViewById(R.id.order_view);
        orderView.hasFixedSize();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        orderView.setLayoutManager(layoutManager);

        orderAdapter = new OrderAdapter(orderList);
        orderView.setAdapter(orderAdapter);
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
            Intent intent = new Intent(this, CustomerProfileView.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.orders_button) {
            Intent intent = new Intent(this, BasketListView.class);
            startActivity(intent);
        }
        return true;
    }

    @Override
    public void ListOrders(List<Order> orderList) {
        this.orderList.addAll(orderList);
        orderAdapter.notifyDataSetChanged();
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

