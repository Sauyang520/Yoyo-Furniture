package com.yoyofurniture.bean;

public class Customer extends User{
    private String phone;
    private String address;

    public Customer(String userID, String name, String phone, String address) {
        super(userID, null, name);
        this.phone = phone;
        this.address = address;
    }


    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    /**
     * Format customer information to string to be stored in to txt file
     * @return prepared officer string
     */
    @Override
    public String formatInfo() {
        return getUserID()+"|"+getName()+"|"+getPhone()+"|"+getAddress();
    }
}
