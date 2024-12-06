package com.example.restaurantapp;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.restaurantapp.contract.RegisterCustomerContract;
import com.example.restaurantapp.presenter.RegisterCustomerPresenter;
import com.example.restaurantapp.domain.Customer;
import com.example.restaurantapp.view.RestaurantListView;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;


public class RegisterActivity extends AppCompatActivity implements RegisterCustomerContract.View {

    private RegisterCustomerPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        presenter = new RegisterCustomerPresenter(this);
    }

    public void addCustomer(View view) {
        try {
            EditText CustomerName = findViewById(R.id.username);
            EditText CustomerPhone = findViewById(R.id.phone);
            EditText CustomerEmail = findViewById(R.id.email);
            EditText CustomerPassword = findViewById(R.id.password);

            String name = CustomerName.getText().toString();
            String phone = CustomerPhone.getText().toString();
            String email = CustomerEmail.getText().toString();
            String password = CustomerPassword.getText().toString();
            String role = "customer";

            Customer customer = new Customer(name, email, phone, password, role);
            presenter.registerCustomer(customer);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showErrorMessage(String message) {
        Snackbar.make(findViewById(R.id.registerButton), message, BaseTransientBottomBar.LENGTH_INDEFINITE).show();
    }

    @Override
    public void showSuccessMessage(String message) {
        Snackbar.make(findViewById(R.id.registerButton), message, BaseTransientBottomBar.LENGTH_SHORT)
                .addCallback(new Snackbar.Callback() {
                    @Override
                    public void onDismissed(Snackbar snackbar, int event) {
                        super.onDismissed(snackbar, event);
                        Intent intent = new Intent(RegisterActivity.this, RestaurantListView.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .show();
    }
}