package com.example.restaurantapp.contract;

import com.example.restaurantapp.domain.Customer;

import java.util.List;

public interface CustomerListContract {
    interface Model {
        interface OnCustomerLoadedListener {
            void onLoadCustomersSuccess(List<Customer> customerList);
            void onLoadCustomerSuccess(Customer customer);
            void onLoadCustomerFailed(String message);
        }
        void loadCustomers(OnCustomerLoadedListener listener);
        void loadCustomer(OnCustomerLoadedListener listener, int customerId);
    }

    interface View {
        void ListCustomers(List<Customer> menuitemList);
        void ListCustomer(Customer customer);
        void showErrorMessage(String message);
        void showSuccessMessage(String message);
    }

    interface Presenter {
        void loadCustomers();
        void loadCustomer(int customerId);
    }
}