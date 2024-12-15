package com.example.restaurantapp.contract;

import com.example.restaurantapp.domain.Beverage;

import java.util.List;

public interface BeverageListContract {
    interface Model {
        interface OnBeverageLoadedListener {
            void onLoadBeverageSuccess(List<Beverage> beverageList);
            void onLoadBeverageFailed(String message);
        }
        void loadBeverages(OnBeverageLoadedListener listener);
    }

    interface View {
        void ListBeverages(List<Beverage> beverageList);
        void showErrorMessage(String message);
        void showSuccessMessage(String message);
    }

    interface Presenter {
        void loadBeverages();
    }
}