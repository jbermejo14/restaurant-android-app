package com.example.restaurantapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.restaurantapp.adapter.ReservationAdapter;
import com.example.restaurantapp.domain.Reservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationActivity extends AppCompatActivity {
    private ReservationAdapter reservationAdapter;
    private List<Reservation> reservationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservation_activity);

        populateList();

        RecyclerView customerView = findViewById(R.id.customer_view);
        customerView.hasFixedSize();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        customerView.setLayoutManager(layoutManager);

        reservationAdapter = new ReservationAdapter(reservationList);
        customerView.setAdapter(reservationAdapter);
    }

    private void populateList() {
        reservationList = new ArrayList<>();
        reservationList.add(new Reservation(1, "James", "email@email.com", "312341234", "adfasdfasdf", LocalDate.now()));
    }

}
