package com.example.restaurantapp.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.restaurantapp.R;
import com.example.restaurantapp.domain.Restaurant;
import com.example.restaurantapp.view.MenuItemListView;


import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantHolder> {

    private List<Restaurant> restaurantList;

    public RestaurantAdapter(List<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }

    @NonNull
    @Override
    public RestaurantAdapter.RestaurantHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.restaurant_view_item, parent, false);
        return new RestaurantHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantAdapter.RestaurantHolder holder, int position) {
        holder.name.setText(restaurantList.get(position).getName());
        holder.address.setText(restaurantList.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    public class RestaurantHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView address;

        public RestaurantHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.item_name);
            address = itemView.findViewById(R.id.item_address);

            itemView.setOnClickListener(view -> {
                Intent intent = new Intent(itemView.getContext(), MenuItemListView.class);

                intent.putExtra("name", name.getText().toString());
                intent.putExtra("address", address.getText().toString());

                itemView.getContext().startActivity(intent);
            });
        }

    }
}
