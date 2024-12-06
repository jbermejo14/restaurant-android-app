package com.example.restaurantapp.contract;

import com.example.restaurantapp.domain.Customer;

import java.util.List;

public interface CustomerListContract {
    interface Model {
        interface OnCustomerLoadedListener {
            void onLoadCustomerSuccess(List<Customer> customerList);
            void onLoadCustomerFailed(String message);
        }
        void loadCustomers(OnCustomerLoadedListener listener);
    }

    interface View {
        void ListCustomers(List<Customer> menuitemList);
        void showErrorMessage(String message);
        void showSuccessMessage(String message);
    }

    interface Presenter {
        void loadCustomers();
    }
}