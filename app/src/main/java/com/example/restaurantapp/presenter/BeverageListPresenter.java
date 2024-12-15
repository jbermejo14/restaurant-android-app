package com.example.restaurantapp.presenter;

import com.example.restaurantapp.contract.BeverageListContract;
import com.example.restaurantapp.domain.Beverage;
import com.example.restaurantapp.model.BeverageListModel;

import java.util.List;

public class BeverageListPresenter implements BeverageListContract.Presenter, BeverageListContract.Model.OnBeverageLoadedListener {

    private BeverageListContract.View view;
    private BeverageListContract.Model model;

    public BeverageListPresenter(BeverageListContract.View view) {
        this.view = view;
        model = new BeverageListModel();
    }

    @Override
    public void onLoadBeverageSuccess(List<Beverage> beverageList) {
        view.ListBeverages(beverageList);
    }

    @Override
    public void onLoadBeverageFailed(String message) {
        view.showErrorMessage(message);
    }

    @Override
    public void loadBeverages() {
        model.loadBeverages(this);
    }

}