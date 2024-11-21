package com.example.restaurantapp.domain;

import java.util.Date;

public class Reservation {

    private long id;
    private Date reservationDate;
    private int numOfGuests;
    private Customer customer;
    private Table table;
    private String status;
}
