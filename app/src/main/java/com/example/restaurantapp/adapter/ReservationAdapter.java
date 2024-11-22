package com.example.restaurantapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.restaurantapp.R;
import com.example.restaurantapp.domain.Customer;
import com.example.restaurantapp.domain.Reservation;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ReservationAdapter extends RecyclerView.Adapter<ReservationAdapter.ReservationHolder> {

    private List<Reservation> reservationList;

    public ReservationAdapter(List<Reservation> customerList) {
        this.reservationList = customerList;
    }

    @NotNull
    @Override
    public ReservationAdapter.ReservationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.customer_view_item, parent, false);
        return new ReservationHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReservationAdapter.ReservationHolder reservationHolder, int position) {
        reservationHolder.reservationDate.setText(String.valueOf(reservationList.get(position).getReservationDate()));
        reservationHolder.numOfGuests.setText(reservationList.get(position).getNumOfGuests());
    }

    @Override
    public int getItemCount() {
        return reservationList.size();
    }

    public class ReservationHolder extends RecyclerView.ViewHolder {

        private TextView reservationDate;
        private TextView numOfGuests;

        public ReservationHolder(@NonNull View itemView) {
            super(itemView);

//            ADD RESERVATION ITEMS
            reservationDate = itemView.findViewById(R.id.item_reservationDate);
            numOfGuests = itemView.findViewById(R.id.item_numOfGuests);
        }
    }
}

