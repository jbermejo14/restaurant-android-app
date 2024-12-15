package com.example.restaurantapp.contract;

import com.example.restaurantapp.domain.Order;

import java.util.List;

public interface OrderListContract {
    interface Model {
        interface OnOrderLoadedListener {
            void onLoadOrderSuccess(List<Order> orderList);
            void onLoadOrderFailed(String message);
        }
        void loadOrders(OnOrderLoadedListener listener);
    }

    interface View {
        void ListOrders(List<Order> orderList);
        void showErrorMessage(String message);
        void showSuccessMessage(String message);
    }

    interface Presenter {
        void loadOrders();
    }
}
