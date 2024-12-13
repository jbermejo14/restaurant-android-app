package com.example.restaurantapp.contract;

import com.example.restaurantapp.domain.Order;

import java.util.List;

public interface RegisterOrderContract {

    void showErrorMessage(String message);

    void showSuccessMessage(String message);

    interface Model {
        interface OnRegisterOrderListener {
            void onRegisterOrderSuccess(Order registeredOrder);
            void onRegisterOrderError(String message);
        }
        void registerOrder(Order customer, OnRegisterOrderListener listener);
    }

    interface View {
        //void listCustomer(List<Customer> customerList);
        void showErrorMessage(String message);
        void showSuccessMessage(String message);
    }

    interface Presenter {
        void registerOrder(Order customer);
    }
}
