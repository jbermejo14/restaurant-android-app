package com.example.restaurantapp.presenter;

import com.example.restaurantapp.contract.RestaurantListContract;
import com.example.restaurantapp.domain.Restaurant;
import com.example.restaurantapp.model.RestaurantListModel;

import java.util.List;

public class RestaurantListPresenter implements RestaurantListContract.Presenter, RestaurantListContract.Model.OnRestaurantLoadedListener {

    private RestaurantListContract.View view;
    private RestaurantListContract.Model model;

    public RestaurantListPresenter(RestaurantListContract.View view) {
        this.view = view;
        model = new RestaurantListModel();
    }

    @Override
    public void onLoadRestaurantSuccess(List<Restaurant> restaurantList) {
        view.ListRestaurants(restaurantList);
    }

    @Override
    public void onLoadRestaurantFailed(String message) {
        view.showErrorMessage(message);
    }

    @Override
    public void loadRestaurants() {
        model.loadRestaurants(this);
    }

}
