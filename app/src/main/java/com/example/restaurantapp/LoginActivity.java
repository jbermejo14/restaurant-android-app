package com.example.restaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.restaurantapp.contract.CustomerListContract;
import com.example.restaurantapp.domain.Customer;
import com.example.restaurantapp.presenter.CustomerListPresenter;
import com.example.restaurantapp.view.RestaurantListView;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class LoginActivity extends AppCompatActivity implements CustomerListContract.View {

    private EditText customerNameField;
    private EditText customerPasswordField;
    private CustomerListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        customerNameField = findViewById(R.id.username);
        customerPasswordField = findViewById(R.id.password);

        presenter = new CustomerListPresenter(this);

        presenter.loadCustomers();
    }

    public void validateCustomer(View view) {
        String name = customerNameField.getText().toString().trim();
        String password = customerPasswordField.getText().toString().trim();

        if (name.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter both username and password", Toast.LENGTH_SHORT).show();
            return;
        }
        presenter.loadCustomers();
    }

    public void registerPage(View view) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void ListCustomers(List<Customer> customerList) {
        // Perform validation here
        String enteredName = customerNameField.getText().toString();
        String enteredPassword = customerPasswordField.getText().toString();

        for (Customer customer : customerList) {
            if (customer.getName().equals(enteredName) && customer.getPassword().equals(enteredPassword)) {
                showSuccessMessage("Login successful!");
                return;
            }
        }
        showErrorMessage("Invalid username or password.");
    }

    @Override
    public void showErrorMessage(String message) {
        Snackbar.make(findViewById(R.id.loginButton), message, BaseTransientBottomBar.LENGTH_INDEFINITE).show();
    }

    @Override
    public void showSuccessMessage(String message) {
        Snackbar.make(findViewById(R.id.loginButton), message, BaseTransientBottomBar.LENGTH_SHORT)
                .addCallback(new Snackbar.Callback() {
                    @Override
                    public void onDismissed(Snackbar snackbar, int event) {
                        super.onDismissed(snackbar, event);
                        Intent intent = new Intent(LoginActivity.this, RestaurantListView.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .show();
    }
}
