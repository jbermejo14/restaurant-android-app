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

        populateList();

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

    public boolean onCreateItemSelected(@NotNull MenuItem item) {
        if (item.getItemId() == R.id.action_map) {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        } else if (item.getItemId()  == R.id.action_register_customer) {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        }
        return true;
    }

    private void populateList() {
        customerList = new ArrayList<>();
        customerList.add(new Customer(1, "James", "email@email.com", "312341234", "adfasdfasdf", LocalDate.now()));
    }

}
