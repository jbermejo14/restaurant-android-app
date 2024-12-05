package com.example.restaurantapp.presenter;

import com.example.restaurantapp.contract.MenuItemListContract;
import com.example.restaurantapp.domain.MenuItem;
import com.example.restaurantapp.model.MenuItemsListModel;

import java.util.List;

public class MenuItemListPresenter implements MenuItemListContract.Presenter, MenuItemListContract.Model.OnMenuItemLoadedListener {

    private MenuItemListContract.View view;
    private MenuItemListContract.Model model;

    public MenuItemListPresenter(MenuItemListContract.View view) {
        this.view = view;
        model = new MenuItemsListModel();
    }

    @Override
    public void onLoadMenuItemSuccess(List<MenuItem> menuItemList) {
        view.ListMenuItems(menuItemList);
    }

    @Override
    public void onLoadMenuItemFailed(String message) {
        view.showErrorMessage(message);
    }

    @Override
    public void loadMenuItems() {
        model.loadMenuItems(this);
    }

}
