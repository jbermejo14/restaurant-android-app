package com.example.restaurantapp.presenter;

import com.example.restaurantapp.contract.OrderListContract;
import com.example.restaurantapp.contract.RestaurantListContract;
import com.example.restaurantapp.domain.Order;
import com.example.restaurantapp.domain.Restaurant;
import com.example.restaurantapp.model.OrderListModel;
import com.example.restaurantapp.model.RestaurantListModel;

import java.util.List;

public class OrderListPresenter implements OrderListContract.Presenter, OrderListContract.Model.OnOrderLoadedListener {

    private OrderListContract.View view;
    private OrderListContract.Model model;

    public OrderListPresenter(OrderListContract.View view) {
        this.view = view;
        model = new OrderListModel();
    }

    @Override
    public void onLoadOrderSuccess(List<Order> orderList) {
        view.ListOrders(orderList);
    }

    @Override
    public void onLoadOrderFailed(String message) {
        view.showErrorMessage(message);
    }

    @Override
    public void loadOrders() {
        model.loadOrders(this);
    }

}
