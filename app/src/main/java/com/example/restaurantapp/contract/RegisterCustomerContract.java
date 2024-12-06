package com.example.restaurantapp.contract;


import com.example.restaurantapp.domain.Customer;

import java.util.List;

public interface RegisterCustomerContract {

    void showErrorMessage(String message);

    void showSuccessMessage(String message);

    interface Model {
        interface OnRegisterCustomerListener {
            void onRegisterCustomerSuccess(Customer registeredCustomer);
            void onRegisterCustomerError(String message);
        }
        void registerCustomer(Customer customer, OnRegisterCustomerListener listener);
    }

    interface View {
        //void listCustomer(List<Customer> customerList);
        void showErrorMessage(String message);
        void showSuccessMessage(String message);
    }

    interface Presenter {
        void registerCustomer(Customer customer);
    }
}
