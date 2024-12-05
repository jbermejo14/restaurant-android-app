package com.example.restaurantapp.contract;

import com.example.restaurantapp.domain.MenuItem;

import java.util.List;

public interface MenuItemListContract {
    interface Model {
        interface OnMenuItemLoadedListener {
            void onLoadMenuItemSuccess(List<MenuItem> menuitemList);
            void onLoadMenuItemFailed(String message);
        }
        void loadMenuItems(OnMenuItemLoadedListener listener);
    }

    interface View {
        void ListMenuItems(List<MenuItem> menuitemList);
        void showErrorMessage(String message);
        void showSuccessMessage(String message);
    }

    interface Presenter {
        void loadMenuItems();
    }
}
