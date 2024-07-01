package com.yoyofurniture.bean;

import com.yoyofurniture.utility.HandleAccount;
import com.yoyofurniture.utility.HandleSales;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Salesperson extends User {
    private String gender;
    private String dateOfBirth;
    private String phoneNumber;
    private String email;

    public Salesperson(String userID, String password, String name, String gender, String dateOfBirth, String phoneNumber, String email) {
        super(userID, password, name);
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }


    /**
     * Login function for salesperson
     * @param userID the entered user ID
     * @param password the entered password
     * @return true: the ID and password match text file, false: either ID or password or both incorrect
     */
    public static String[] loginSalesperson(String userID, String password) {
        return User.login("salesperson.txt", userID, password);
    }

    /**
     * Add new customer
     * @param customer customer information in string array
     * @param newId newID list to be replaced
     * @throws Exception exception
     */
    public void addNewCustomer(Customer customer, String[] newId) throws Exception {
            HandleAccount.addData("customer.txt", customer.formatInfo());
            HandleAccount.writeAllData("id.txt", new ArrayList<>(List.of(String.join(",", newId))));
    }

    /**
     * add item to cart
     * @param product product added to cart
     * @param quantity selected item quantity
     */
    public void addItemToCart(Product product, int quantity){
        HandleSales.getHandleSalesInstance().addItemToCart(product, quantity);
    }

    /**
     * change the item quantity in cart
     * @param selectedProduct product which its quantity to be changed
     * @param quantity new quantity
     */
    public void changeItemQuantity(SelectedProduct selectedProduct, int quantity){
        selectedProduct.setQuantity(quantity);
    }

    /**
     * remove item from cart
     * @param cart cart
     * @param itemID item to be remove
     */
    public void removeItem(List<SelectedProduct> cart, String itemID){
        cart.removeIf(selectedProduct -> selectedProduct.getProduct().getItemID().equals(itemID));
    }

    /**
     * place an order
     * @param selectedCustID customer id
     * @throws Exception exception
     */
    public void placeOrder(String selectedCustID) throws Exception {
        HandleSales.getHandleSalesInstance().placeNewOrder(this, selectedCustID);
    }

    /**
     * Delete the pending / unapproved / approved Sale order
     * @param saleOrderList the whole sale order list
     * @param saleID sale id to be deleted
     * @return successfully delete or failed
     * @throws Exception exception
     */
    public boolean deleteSaleOrder(List<SaleOrder> saleOrderList, String saleID) throws Exception {
        SaleOrder saleOrder = saleOrderList.stream().filter(saleOrder1 -> saleOrder1.getSaleID().equals(saleID))
                .findFirst().get();
        if (saleOrder.getStatus().equals(Status.UNAPPROVED.getStatus()) ||
                saleOrder.getStatus().equals(Status.APPROVED.getStatus()) ||
                saleOrder.getStatus().equals(Status.PENDING.getStatus())) {
            saleOrderList.remove(saleOrder);
            HandleSales.getHandleSalesInstance().saveAllSalesOrder(saleOrderList);
            return true;
        }
        return false;
    }

    /**
     * Save Salesperson Personal Info
     *
     * @param newInfo       New info array of admin
     * @param changePass    is change password button enabled
     * @param salesperson   the current salesperson object
     */
    public static void savePersonal(String[] newInfo, boolean changePass, Salesperson salesperson){
        List<String> lines = new ArrayList<>();
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/com.yoyofurniture.data/salesperson.txt"));
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(salesperson.getUserID())) {
                    if (changePass) {
                        parts[1] = HandleAccount.hashString(newInfo[1]);
                    }
                    parts[2] = newInfo[2];
                    parts[3] = newInfo[3];
                    parts[4] = newInfo[4];
                    parts[5] = newInfo[5];
                    parts[6] = newInfo[6];
                    line = String.join(",", parts);
                }
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/com.yoyofurniture.data/salesperson.txt"))) {
            for (String line : lines) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String formatInfo(){
        return getUserID()+","+getPassword()+","+getName()+","+gender+","+dateOfBirth+","+phoneNumber+","+email;
    }
}
