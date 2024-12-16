package com.example.restaurantapp.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.restaurantapp.R;
import com.example.restaurantapp.contract.CustomerListContract;
import com.example.restaurantapp.domain.Customer;
import com.example.restaurantapp.domain.MenuItem;
import com.example.restaurantapp.presenter.CustomerListPresenter;

import java.util.ArrayList;
import java.util.List;

public class CustomerProfileView extends AppCompatActivity implements CustomerListContract.View {

    private TextView userName, userEmail, userPhone, userPassword;
    private Button editButton;
    private CustomerListPresenter presenter;
    public static final String SHARED_PREFS = "shared_prefs";

    // key for storing email.
    public static final String USER_KEY = "user_key";

    // key for storing password.
    public static final String PASSWORD_KEY = "password_key";
    SharedPreferences sharedpreferences;
    String customerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_profile);

        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        customerName = sharedpreferences.getString(USER_KEY, null);

        // Initialize Views
        userName = findViewById(R.id.userName);
        userPassword = findViewById(R.id.userPassword);
        editButton = findViewById(R.id.editButton);

        // Initialize Presenter
        presenter = new CustomerListPresenter(this);

        presenter.loadCustomer(0);

        editButton.setOnClickListener(v -> onEditButtonClicked());
        userName.setText(customerName);
        userPassword.setText("••••••••");
    }

    private void onEditButtonClicked() {
        Intent intent = new Intent(this, EditCustomer.class);
        startActivity(intent);
    }
    @Override
    public void ListCustomers(List<Customer> menuitemList) {

    }

    @Override
    public void ListCustomer(Customer customer) {
    }

    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    public void showSuccessMessage(String message) {

    }
}
