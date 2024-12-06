package com.example.restaurantapp.presenter;


import com.example.restaurantapp.contract.CustomerListContract;
import com.example.restaurantapp.domain.Customer;
import com.example.restaurantapp.model.CustomerListModel;

import java.util.ArrayList;
import java.util.List;

public class CustomerListPresenter implements CustomerListContract.Presenter, CustomerListContract.Model.OnCustomerLoadedListener {

    private CustomerListContract.Model model;

    private final CustomerListContract.View view;

    public CustomerListPresenter(CustomerListContract.View view) {
        this.view = view;
        this.model = new CustomerListModel();
    }

    @Override
    public void onLoadCustomerSuccess(List<Customer> customerList) {
        view.ListCustomers(customerList);
    }

    @Override
    public void onLoadCustomerFailed(String message) {
        view.showErrorMessage(message);
    }

    @Override
    public void loadCustomers() {
        model.loadCustomers(this);
    }
}
