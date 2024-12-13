package com.example.restaurantapp.contract;

import com.example.restaurantapp.domain.Customer;

public interface CustomerRoleContract {
    interface View {

        void showCustomer(Customer customer);
        void showError(String errorMessage);
        void invalidateMenu(String role); // Called to update menu items
    }

    interface Presenter {
        void loadCustomer(String userId);
    }

    interface Model {
        interface CustomerListener {
            void onCustomerLoaded(Customer customer);
            void onError(String errorMessage);
        }
        void fetchCustomer(String customerId, CustomerListener listener);
    }


}
