/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yoyofurniture.bean;

/**
 *
 * @author petywh
 */
public class OrderEntry {
    private String saleID;
    private String salesperson;
    private String saleDateTime;
    private Product product;
    private int quantity;
    private double amount;
    private String status;

    // Constructor
    public OrderEntry(String saleID, String salesperson, String saleDateTime, Product product, int quantity, double amount) {
        this.saleID = saleID;
        this.salesperson = salesperson;
        this.saleDateTime = saleDateTime;
        this.product = product;
        this.quantity = quantity;
        this.amount = amount;
    }
    
    public OrderEntry(String saleID, String salesperson, String saleDateTime, Product product, int quantity, double amount, String status) {
        this.saleID = saleID;
        this.salesperson = salesperson;
        this.saleDateTime = saleDateTime;
        this.product = product;
        this.quantity = quantity;
        this.amount = amount;
        this.status = status;
    }
    
    public String getSaleID() {
        return saleID;
    }

    public String getSalesperson() {
        return salesperson;
    }

    public String getSaleDateTime() {
        return saleDateTime;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getAmount() {
        return amount;
    }
    
    public String getStatus(){
        return status;
    }
}



