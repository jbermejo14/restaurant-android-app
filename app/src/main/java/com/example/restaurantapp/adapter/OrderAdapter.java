package com.example.restaurantapp.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.restaurantapp.R;
import com.example.restaurantapp.domain.Order;
import com.example.restaurantapp.view.MenuItemListView;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderHolder> {

    private List<Order> orderList;

    public OrderAdapter(List<Order> orderList) {
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public OrderAdapter.OrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order_view_item, parent, false);
        return new OrderHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.OrderHolder holder, int position) {
        Order order = orderList.get(position);
        if (order != null) {
            holder.totalPrice.setText(String.valueOf(order.getTotalPrice()));
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            holder.orderDate.setText(dateFormat.format(order.getOrderDate()));
        }
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class OrderHolder extends RecyclerView.ViewHolder {

        private TextView totalPrice;
        private TextView orderDate;

        public OrderHolder(@NonNull View itemView) {
            super(itemView);

            totalPrice = itemView.findViewById(R.id.totalPrice);
            orderDate = itemView.findViewById(R.id.orderDate);

            itemView.setOnClickListener(view -> {
                Intent intent = new Intent(itemView.getContext(), MenuItemListView.class);

                intent.putExtra("totalPrice", totalPrice.getText().toString());
                intent.putExtra("orderDate", orderDate.getText().toString());

                itemView.getContext().startActivity(intent);
            });
        }

    }
}
