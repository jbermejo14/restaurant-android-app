package com.example.restaurantapp.contract;

import com.example.restaurantapp.domain.Restaurant;

import java.util.List;

public interface RestaurantListContract {
    interface Model {
        interface OnRestaurantLoadedListener {
            void onLoadRestaurantSuccess(List<Restaurant> restaurantList);
            void onLoadRestaurantFailed(String message);
        }
        void loadRestaurants(OnRestaurantLoadedListener listener);
    }

    interface View {
        void ListRestaurants(List<Restaurant> restaurantList);
        void showErrorMessage(String message);
        void showSuccessMessage(String message);
    }

    interface Presenter {
        void loadRestaurants();
    }
}
