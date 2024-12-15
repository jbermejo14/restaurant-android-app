package com.example.restaurantapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.restaurantapp.R;
import com.example.restaurantapp.domain.Beverage;

import java.util.ArrayList;
import java.util.List;


public class BeverageAdapter extends RecyclerView.Adapter<BeverageAdapter.BeverageHolder> {

    private List<Beverage> beverageList;
    private List<Beverage> selectedBeverages = new ArrayList<>();  // To track the selected menu items

    public BeverageAdapter(List<Beverage> beverageList) {
        this.beverageList = beverageList;
    }

    @NonNull
    @Override
    public BeverageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menuitem_view_item, parent, false);
        return new BeverageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BeverageHolder holder, int position) {
        Beverage beverage = beverageList.get(position);
        holder.name.setText(beverage.getName());
        holder.description.setText(beverage.getDescription());

        // Handle radio button state
        holder.radioButton.setChecked(selectedBeverages.contains(beverage));

        // Set listener for radio button click
        holder.radioButton.setOnClickListener(v -> {
            if (selectedBeverages.contains(beverage)) {
                selectedBeverages.remove(beverage);  // Deselect item if it was already selected
            } else {
                selectedBeverages.add(beverage);  // Select item
            }
            notifyDataSetChanged();  // Notify adapter to update the view
        });
    }

    @Override
    public int getItemCount() {
        return beverageList.size();
    }

    public List<Beverage> getSelectedBeverages() {
        return selectedBeverages;
    }

    public class BeverageHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView description;
        private RadioButton radioButton;

        public BeverageHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.item_name);
            description = itemView.findViewById(R.id.item_description);
            radioButton = itemView.findViewById(R.id.radioButton);  // Assuming you have a RadioButton in your item layout
        }
    }
}