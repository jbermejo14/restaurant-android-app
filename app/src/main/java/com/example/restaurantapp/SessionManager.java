package com.example.restaurantapp;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    private static final String PREF_NAME = "SessionManager";
    private static final String KEY_CUSTOMER_ID = "customer_id";
    private final SharedPreferences sharedPreferences;
    private final SharedPreferences.Editor editor;

    public SessionManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveCustomerId(long customerId) {
        editor.putLong(KEY_CUSTOMER_ID, customerId);
        editor.apply();
    }

    public long getCustomerId() {
        return sharedPreferences.getLong(KEY_CUSTOMER_ID, -1); // Default -1 if not set
    }
}
