package com.example.restaurantapp.domain;

import java.util.Date;

public class Reservation {

    private long id;
    private Date reservationDate;
    private Customer customer;
    private String status;
    private MenuItem menuItem;

    public Reservation(long id, Date reservationDate, Customer customer, MenuItem menuItem, String status) {
        this.id = id;
        this.reservationDate = reservationDate;
        this.customer = customer;
        this.status = status;
        this.menuItem = menuItem;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
