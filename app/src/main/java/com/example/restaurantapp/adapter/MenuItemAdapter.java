package com.example.restaurantapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.restaurantapp.R;
import com.example.restaurantapp.domain.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MenuItemAdapter extends RecyclerView.Adapter<MenuItemAdapter.MenuItemHolder> {

    private List<MenuItem> menuItemList;
    private List<MenuItem> selectedMenuItems = new ArrayList<>();  // To track the selected menu items

    public MenuItemAdapter(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    @NonNull
    @Override
    public MenuItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menuitem_view_item, parent, false);
        return new MenuItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuItemHolder holder, int position) {
        MenuItem menuItem = menuItemList.get(position);
        holder.name.setText(menuItem.getName());
        holder.description.setText(menuItem.getDescription());

        // Handle radio button state
        holder.radioButton.setChecked(selectedMenuItems.contains(menuItem));

        // Set listener for radio button click
        holder.radioButton.setOnClickListener(v -> {
            if (selectedMenuItems.contains(menuItem)) {
                selectedMenuItems.remove(menuItem);  // Deselect item if it was already selected
            } else {
                selectedMenuItems.add(menuItem);  // Select item
            }
            notifyDataSetChanged();  // Notify adapter to update the view
        });
    }

    @Override
    public int getItemCount() {
        return menuItemList.size();
    }

    public List<MenuItem> getSelectedMenuItems() {
        return selectedMenuItems;  // Return the list of selected menu items
    }

    public class MenuItemHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView description;
        private RadioButton radioButton;

        public MenuItemHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.item_name);
            description = itemView.findViewById(R.id.item_description);
            radioButton = itemView.findViewById(R.id.radioButton);  // Assuming you have a RadioButton in your item layout
        }
    }
}
