package com.example.restaurantapp;

import com.example.restaurantapp.domain.Customer;

public interface CustomerRoleView {
    void showLoading(); // Show a loading indicator
    void hideLoading(); // Hide the loading indicator
    void showUser(Customer customer); // Display user details
    void showError(String errorMessage); // Display an error
}
