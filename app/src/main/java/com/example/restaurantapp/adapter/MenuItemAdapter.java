package com.example.restaurantapp.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.restaurantapp.R;
import com.example.restaurantapp.domain.MenuItem;
import com.example.restaurantapp.domain.Restaurant;
import com.example.restaurantapp.view.DetailRestaurantActivity;


import java.util.List;

public class MenuItemAdapter extends RecyclerView.Adapter<MenuItemAdapter.MenuItemHolder> {

    private List<MenuItem> menuItemList;

    public MenuItemAdapter(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    @NonNull
    @Override
    public MenuItemAdapter.MenuItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menuitem_view_item, parent, false);
        return new MenuItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuItemAdapter.MenuItemHolder holder, int position) {
        holder.name.setText(menuItemList.get(position).getName());
        holder.description.setText(menuItemList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return menuItemList.size();
    }

    public class MenuItemHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView description;

        public MenuItemHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.item_name);
            description = itemView.findViewById(R.id.item_description);

        }

    }
}
