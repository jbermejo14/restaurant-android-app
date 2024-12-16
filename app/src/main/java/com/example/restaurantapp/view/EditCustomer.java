package com.example.restaurantapp.view;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.restaurantapp.R;

public class EditCustomer extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private EditText password2EditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_customer);

        // Initialize the EditText fields
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        password2EditText = findViewById(R.id.password2);
    }

    // Method to validate the customer input when the "Edit Profile" button is clicked
    public void validateCustomer(android.view.View view) {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String password2 = password2EditText.getText().toString();

        // Validate inputs
        if (username.isEmpty()) {
            Toast.makeText(this, "Username cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.isEmpty()) {
            Toast.makeText(this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(password2)) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

//        updateCustomerProfile(username, password);
    }

    private void updateCustomerProfile(String username, String password) {
        Toast.makeText(this, "Profile updated successfully!", Toast.LENGTH_SHORT).show();
    }
}
