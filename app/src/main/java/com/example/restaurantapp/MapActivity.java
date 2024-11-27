package com.example.restaurantapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import com.mapbox.maps.MapView;
import com.mapbox.maps.Style;

public class MapActivity extends AppCompatActivity {

    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        mapView = findViewById(R.id.mapView);
        mapView.getMapboxMap().loadStyleUri(Style.MAPBOX_STREETS);
    }
}
