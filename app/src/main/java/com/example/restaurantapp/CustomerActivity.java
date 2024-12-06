package com.example.restaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.restaurantapp.adapter.CustomerAdapter;
import com.example.restaurantapp.domain.Customer;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerActivity extends AppCompatActivity {
    private CustomerAdapter customerAdapter;
    private List<Customer> customerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_activity);

        RecyclerView customerView = findViewById(R.id.customer_view);
        customerView.hasFixedSize();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        customerView.setLayoutManager(layoutManager);

        customerAdapter = new CustomerAdapter(customerList);
        customerView.setAdapter(customerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar, menu);
        return true;
    }

}
