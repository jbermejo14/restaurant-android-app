package com.example.restaurantapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.restaurantapp.adapter.CustomerAdapter;
import com.example.restaurantapp.domain.Customer;

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

    private void populateList() {
        customerList = new ArrayList<>();
        customerList.add(new Customer(1, "James", "email@email.com", "312341234", "adfasdfasdf", LocalDate.now()));
    }

}
