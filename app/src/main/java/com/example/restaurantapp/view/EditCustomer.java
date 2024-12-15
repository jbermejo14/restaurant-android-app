package com.example.restaurantapp.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.restaurantapp.R;
import com.example.restaurantapp.contract.CustomerListContract;
import com.example.restaurantapp.domain.Customer;
import com.example.restaurantapp.presenter.CustomerListPresenter;

import java.util.List;

public class EditCustomer extends AppCompatActivity implements CustomerListContract.View {

    private TextView userName, userEmail, userPhone, userPassword;
    private Button editButton;
    private CustomerListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_customer);

        // Initialize Views
        userName = findViewById(R.id.userName);
        userEmail = findViewById(R.id.userEmail);
        userPhone = findViewById(R.id.userPhone);
        userPassword = findViewById(R.id.userPassword);
        editButton = findViewById(R.id.editButton);

        // Initialize Presenter
        presenter = new CustomerListPresenter(this);

        presenter.loadCustomer(1);
        editButton.setOnClickListener(v -> Toast.makeText(this, "Edit Profile Clicked", Toast.LENGTH_SHORT).show());
    }

    @Override
    public void ListCustomers(List<Customer> menuitemList) {

    }

    @Override
    public void ListCustomer(Customer customer) {
        userName.setText(customer.getName());
        userEmail.setText(customer.getEmail());
        userPhone.setText(customer.getPhone());
        userPassword.setText("••••••••");
    }

    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    public void showSuccessMessage(String message) {

    }
}
