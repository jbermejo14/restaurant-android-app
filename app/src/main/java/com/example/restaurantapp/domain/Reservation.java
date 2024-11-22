package com.example.restaurantapp.domain;

import java.util.Date;

public class Reservation {

    private long id;
    private Date reservationDate;
    private int numOfGuests;
    private Customer customer;
    private Table table;
    private String status;

    public Reservation(long id, Date reservationDate, int numOfGuests, Customer customer, Table table, String status) {
        this.id = id;
        this.reservationDate = reservationDate;
        this.numOfGuests = numOfGuests;
        this.customer = customer;
        this.table = table;
        this.status = status;
    }

    public int getNumOfGuests() {
        return numOfGuests;
    }

    public void setNumOfGuests(int numOfGuests) {
        this.numOfGuests = numOfGuests;
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

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
