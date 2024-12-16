
package com.example.restaurantapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantapp.domain.MenuItem;
import com.example.restaurantapp.MapActivity;
import com.example.restaurantapp.R;
import com.example.restaurantapp.adapter.BeverageAdapter;
import com.example.restaurantapp.contract.BeverageListContract;
import com.example.restaurantapp.domain.Beverage;
import com.example.restaurantapp.presenter.BeverageListPresenter;

import java.util.ArrayList;
import java.util.List;

public class BeverageListView extends AppCompatActivity implements BeverageListContract.View {
    private BeverageAdapter beverageAdapter;
    private List<Beverage> beverageList;
    private BeverageListContract.Presenter presenter;
    private Button nextButton;
    private ArrayList<MenuItem> selectedMenuItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Retrieve selected MenuItems
        ArrayList<MenuItem> selectedMenuItems = getIntent().getParcelableArrayListExtra("selectedMenuItems");
        if (selectedMenuItems == null) {
            selectedMenuItems = new ArrayList<>();
        }

        beverageList = new ArrayList<>();
        presenter = new BeverageListPresenter(this);
        presenter.loadBeverages();

        RecyclerView beverageView = findViewById(R.id.menu_view);
        beverageView.setLayoutManager(new LinearLayoutManager(this));
        beverageAdapter = new BeverageAdapter(beverageList);
        beverageView.setAdapter(beverageAdapter);

        nextButton = findViewById(R.id.registerMeal);
        ArrayList<MenuItem> finalSelectedMenuItems = selectedMenuItems;
        nextButton.setOnClickListener(v -> onNextButtonClicked(finalSelectedMenuItems)); // Pass existing MenuItems
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        if (item.getItemId() == R.id.action_map) {
            Intent intent = new Intent(this, MapActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.profile_button) {
            Intent intent = new Intent(this, CustomerProfileView.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.orders_button) {
            Intent intent = new Intent(this, BasketListView.class);
            startActivity(intent);
        }
        return true;
    }

    @Override
    public void ListBeverages(List<Beverage> menuitemList) {
        this.beverageList.addAll(menuitemList);
        beverageAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, "Error: " + message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccessMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void onNextButtonClicked(ArrayList<MenuItem> finalSelectedMenuItems) {
        List<Beverage> selectedBeverages = beverageAdapter.getSelectedBeverages();

        if (!selectedBeverages.isEmpty()) {
            // Combine selected menu items and beverages
            ArrayList<Parcelable> combinedList = new ArrayList<>();
            if (finalSelectedMenuItems != null) {
                combinedList.addAll(finalSelectedMenuItems);
            }
            combinedList.addAll(selectedBeverages);

            // Start BasketActivity
            Intent intent = new Intent(this, BasketActivity.class);
            intent.putParcelableArrayListExtra("combinedList", combinedList);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Please select at least one beverage to proceed.", Toast.LENGTH_SHORT).show();
        }
    }
}
