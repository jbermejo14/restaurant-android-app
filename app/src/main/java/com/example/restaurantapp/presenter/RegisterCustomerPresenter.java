package com.example.restaurantapp.presenter;


import com.example.restaurantapp.contract.RegisterCustomerContract;
import com.example.restaurantapp.domain.Customer;
import com.example.restaurantapp.model.RegisterCustomerModel;

public class RegisterCustomerPresenter implements RegisterCustomerContract.Presenter, RegisterCustomerContract.Model.OnRegisterCustomerListener {

    private RegisterCustomerContract.Model model;
    private RegisterCustomerContract.View view;

    public RegisterCustomerPresenter(RegisterCustomerContract.View view) {
        model = new RegisterCustomerModel();
        this.view = view;
    }

    @Override
    public void registerCustomer(Customer customer) {
        if (customer.getName().isEmpty()) {
            view.showErrorMessage("El campo marca no puede estar vacío");
            return;
        }

        model.registerCustomer(customer, this);
    }

    @Override
    public void onRegisterCustomerSuccess(Customer registeredCustomer) {
        view.showSuccessMessage("Customer Registered " + registeredCustomer.getId());
    }

    @Override
    public void onRegisterCustomerError(String message) {
        view.showErrorMessage(message);
    }
}
