package com.example.restaurantapp.adapter;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.restaurantapp.R;
import com.example.restaurantapp.domain.Beverage;
import com.example.restaurantapp.domain.MenuItem;

import java.util.List;

public class BasketAdapter extends RecyclerView.Adapter<BasketAdapter.BasketViewHolder> {

    private List<Parcelable> itemList;

    public BasketAdapter(List<Parcelable> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public BasketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.basket_view_item, parent, false);
        return new BasketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BasketViewHolder holder, int position) {
        Parcelable item = itemList.get(position);

        if (item instanceof MenuItem) {
            MenuItem menuItem = (MenuItem) item;
            holder.name.setText(menuItem.getName());
            holder.description.setText(menuItem.getDescription());
            holder.price.setText(String.valueOf(menuItem.getPrice()));

        } else if (item instanceof Beverage) {
            Beverage beverage = (Beverage) item;
            holder.name.setText(beverage.getName());
            holder.description.setText(beverage.getDescription());
            holder.price.setText(String.valueOf(beverage.getPrice()));
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class BasketViewHolder extends RecyclerView.ViewHolder {
        TextView name, description, price;

        public BasketViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_name);
            description = itemView.findViewById(R.id.item_description);
            price = itemView.findViewById(R.id.item_price);
        }
    }
}

