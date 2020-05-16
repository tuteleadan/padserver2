package com.proiectpad2.domain;

import java.util.List;

public class Comanda{

    private int oid;
    private double totalPrice;
    private int nrItems;
    private String state;
    private int uid;
    private String data;
    private String userEmail;
    private List<Product> orderItems;

    Comanda() {}


    public int getOid() {
        return oid;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getNrItems() {
        return nrItems;
    }

    public String getState() {
        return state;
    }

    public int getUid() {
        return uid;
    }

    public String getData() {
        return data;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public List<Product> getOrderItems() {
        return orderItems;
    }
}