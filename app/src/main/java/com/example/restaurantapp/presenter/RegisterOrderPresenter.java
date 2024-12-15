package com.example.restaurantapp.presenter;

import com.example.restaurantapp.contract.RegisterOrderContract;
import com.example.restaurantapp.domain.Order;
import com.example.restaurantapp.model.RegisterOrderModel;

public class RegisterOrderPresenter implements RegisterOrderContract.Presenter, RegisterOrderContract.Model.OnRegisterOrderListener {

    private RegisterOrderContract.Model model;
    private RegisterOrderContract.View view;

    public RegisterOrderPresenter(RegisterOrderContract.View view) {
        model = new RegisterOrderModel();
        this.view = view;
    }

    @Override
    public void registerOrder(Order order) {
//        if (order.getMenuItems().isEmpty()) {
//            view.showErrorMessage("Order no puede estar vacío");
//            return;
//        }

        model.registerOrder(order, this);

    }

    @Override
    public void onRegisterOrderSuccess(Order registeredOrder) {
        view.showSuccessMessage("Order Registered " + registeredOrder.getId());
    }

    @Override
    public void onRegisterOrderError(String message) {
        view.showErrorMessage(message);
    }
}