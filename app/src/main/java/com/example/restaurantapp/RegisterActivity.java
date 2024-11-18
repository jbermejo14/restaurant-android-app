package com.example.restaurantapp;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.restaurantapp.domain.Customer;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    private List<Customer> customerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        customerList = new ArrayList<>();
    }

    public void addCustomer(View view){
        EditText CustomerUsername = findViewById(R.id.username);
        EditText CustomerPhone = findViewById(R.id.phone);
        EditText CustomerEmail = findViewById(R.id.email);
        EditText CustomerPassword = findViewById(R.id.password);

        String username = CustomerUsername.getText().toString();
        int phone = Integer.parseInt(CustomerPhone.getText().toString());
        String email = CustomerEmail.getText().toString();
        String password = CustomerPassword.getText().toString();

//        Customer customer = new Customer(username, phone, email, password, dateJoined);
    }



        Button registerButton = findViewById(R.id.registerButton);


//        registerButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String username_string = username.getText().toString();
//                String password_string = password.getText().toString();
//                if (!username_string.isEmpty() || !password_string.isEmpty()) {
//                    Toast.makeText(getApplicationContext(), "username: " + username_string, Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(getApplicationContext(), "Please enter a username", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }
}