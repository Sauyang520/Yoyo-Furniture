package com.yoyofurniture.bean;

public class Product {
    private String itemID;
    private String itemName;
    private String itemCategory;
    private double itemPrice;
    private String itemDescription;
    private String itemDesigner;
    private String itemDepth;
    private String itemHeight;
    private String itemWidth;

    public Product() {
    }

    public Product(String itemID, String itemName, String itemCategory, double itemPrice, String itemDescription, String itemDesigner, String itemDepth, String itemHeight, String itemWidth) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        this.itemPrice = itemPrice;
        this.itemDescription = itemDescription;
        this.itemDesigner = itemDesigner;
        this.itemDepth = itemDepth;
        this.itemHeight = itemHeight;
        this.itemWidth = itemWidth;
    }


    public String getItemID() {
        return itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getItemDesigner() {
        return itemDesigner;
    }

    public String getItemDepth() {
        return itemDepth;
    }

    public String getItemHeight() {
        return itemHeight;
    }

    public String getItemWidth() {
        return itemWidth;
    }
}
