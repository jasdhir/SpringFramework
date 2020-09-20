package com.jasdhir.springdemo;

public class Order {
    private int qty;
    private String name;

    public Order( String name,int qty) {
        this.qty = qty;
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
