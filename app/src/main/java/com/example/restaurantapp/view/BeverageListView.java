package com.example.restaurantapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantapp.MapActivity;
import com.example.restaurantapp.R;
import com.example.restaurantapp.adapter.MenuItemAdapter;
import com.example.restaurantapp.contract.MenuItemListContract;
import com.example.restaurantapp.domain.MenuItem;
import com.example.restaurantapp.domain.Reservation;
import com.example.restaurantapp.presenter.MenuItemListPresenter;

import java.util.ArrayList;
import java.util.List;

public class BeverageListView extends AppCompatActivity implements MenuItemListContract.View {

    @Override
    public void ListMenuItems(List<MenuItem> menuitemList) {

    }

    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    public void showSuccessMessage(String message) {

    }
}
