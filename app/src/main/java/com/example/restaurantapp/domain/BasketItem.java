package com.example.restaurantapp.domain;

import android.os.Parcelable;

public class BasketItem {
    public static final int TYPE_MENU_ITEM = 0;
    public static final int TYPE_BEVERAGE = 1;

    private int type; // 0 for MenuItem, 1 for Beverage
    private MenuItem menuItem;
    private Beverage beverage;

    public BasketItem(MenuItem menuItem) {
        this.type = TYPE_MENU_ITEM;
        this.menuItem = menuItem;
    }

    public BasketItem(Beverage beverage) {
        this.type = TYPE_BEVERAGE;
        this.beverage = beverage;
    }

    public int getType() {
        return type;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public Beverage getBeverage() {
        return beverage;
    }
}
