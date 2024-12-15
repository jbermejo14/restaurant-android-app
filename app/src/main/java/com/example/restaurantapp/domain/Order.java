package com.example.restaurantapp.domain;

import java.util.Date;
import java.util.List;

public class Order {
    private long id;
    private List<MenuItem> menuItems;
    private List<Beverage> beverages;
    private Date orderDate;
    private double totalPrice;

    public Order(List<MenuItem> menuItems, List<Beverage> beverages, Date orderDate, double totalPrice) {
        this.menuItems = menuItems;
        this.beverages = beverages;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
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

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
