package com.example.restaurantapp.domain;

import android.os.Parcelable;

import java.util.Date;
import java.util.List;

public class Order {
        private long id;
        private List<MenuItem> menuItems;
        private List<Beverage> beverages;
        private int quantity;
        private double totalPrice;

    public Order(double totalPrice, int quantity, List<MenuItem> menuItems, List<Beverage> beverages) {
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.menuItems = menuItems;
        this.beverages = beverages;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public List<Beverage> getBeverages() {
        return beverages;
    }

    public void setBeverages(List<Beverage> beverages) {
        this.beverages = beverages;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
