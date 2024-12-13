//package com.example.restaurantapp.presenter;
//
//import com.example.restaurantapp.CustomerRoleView;
//import com.example.restaurantapp.api.CustomersApi;
//import com.example.restaurantapp.api.CustomersApiInterface;
//import com.example.restaurantapp.contract.CustomerRoleContract;
//import com.example.restaurantapp.domain.Customer;
//import com.example.restaurantapp.model.CustomerRoleModel;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class CustomerRolePresenter implements CustomerRoleContract.Presenter {
//
//    private CustomerRoleView view;
//    private CustomerRoleModel model;
//
//    public CustomerRolePresenter(CustomerRoleContract.View view, CustomerRoleContract.Model model) {
//        this.view = view;
//        this.model = model;
//    }
//
//    public void loadCustomer() {
//        model.fetchCustomer(customerId, new CustomerRoleContract.Model.CustomerListener() {
//            @Override
//            public void onCustomerLoaded(Customer customer) {
//                view.hideLoading();
//                view.showUser(customer);
//                view.invalidateMenu(customer.getRole());
//            }
//
//            @Override
//            public void onError(String errorMessage) {
//                view.hideLoading();
//                view.showError(errorMessage);
//            }
//        });
//    }
//
//}
//
//
