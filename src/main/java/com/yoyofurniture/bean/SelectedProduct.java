package com.yoyofurniture.bean;

import com.yoyofurniture.utility.HandleSales;
import java.math.BigDecimal;
import java.util.List;

public class SelectedProduct{
    private Product product;
    private int quantity;
    private double amount;

    public SelectedProduct(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.amount = BigDecimal.valueOf(quantity).multiply(BigDecimal.valueOf(product.getItemPrice())).doubleValue();
    }


    public Product getProduct() {
        return product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.amount = BigDecimal.valueOf(quantity).multiply(BigDecimal.valueOf(product.getItemPrice())).doubleValue();
    }

    public int getQuantity() {
        return quantity;
    }

    public double getAmount() {
        return amount;
    }
    
    
    
    
}
