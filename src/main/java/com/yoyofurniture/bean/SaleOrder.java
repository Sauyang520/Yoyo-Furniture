package com.yoyofurniture.bean;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class SaleOrder {
    private String saleID;
    private String salesperson;
    private String customer;
    private String saleDateTime;
    private List<SelectedProduct> productList;
    private double total;
    private String status;

    public SaleOrder(String saleID, String salesperson, String customer, String saleDateTime, List<SelectedProduct> productList, double total, String status) {
        this.saleID = saleID;
        this.salesperson = salesperson;
        this.customer = customer;
        this.saleDateTime = saleDateTime;
        this.productList = productList;
        this.total = total;
        this.status = status;
    }
    
    

    public String getSaleID() {
        return saleID;
    }

    public String getSalesperson() {
        return salesperson;
    }
    
    public void setSalesperson(String salesperson){
        this.salesperson = salesperson;
    }

    public String getSaleDateTime() {
        return saleDateTime;
    }

    public List<SelectedProduct> getProductList() {
        return productList;
    }
    
    public void setProductList(List<SelectedProduct> productList) {
        this.productList = productList;
    }

    public double getTotal() {
        return total;
    }
    
    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status){
        this.status = status;
    }

    public String getCustomer() {
        return customer;
    }
    
    public void setCustomer(String customer){
        this.customer = customer;
    }

    public String formatInfo(){
        List<String> productList = this.getProductList().stream()
                .map(selectedProduct -> selectedProduct.getProduct().getItemID() + "#" + selectedProduct.getQuantity())
                .toList();
        return String.join(",", saleID, salesperson, customer, saleDateTime,
                String.join("|", productList), total + "", Status.PENDING.name());
    }
    
    public String formatNewInfo(){
        List<String> productList = this.getProductList().stream()
                .map(selectedProduct -> selectedProduct.getProduct().getItemID() + "#" + selectedProduct.getQuantity())
                .toList();
        return String.join(",", saleID, salesperson, customer, saleDateTime,
                String.join("|", productList), total + "", status);
    }
    
    @Override
    public String toString() {
        return saleID; // Customize the representation as needed
    }
    
    
}
