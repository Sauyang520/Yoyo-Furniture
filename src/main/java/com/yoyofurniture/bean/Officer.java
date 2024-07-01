package com.yoyofurniture.bean;

import com.yoyofurniture.utility.HandleAccount;
import com.yoyofurniture.utility.HandleSales;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Officer extends User{
    private String phoneNumber;
    private String email;

    public Officer(String userID, String password, String name, String phoneNumber, String email) {
        super(userID, password, name);
        this.phoneNumber = phoneNumber;
        this.email = email;
    }


    /**
     * Login function for officer
     * @param userID the entered user ID
     * @param password the entered password
     * @return true: the ID and password match text file, false: either ID or password or both incorrect
     */
    public static String[] login(String userID, String password){
        return User.login("officer.txt", userID, password);
    }

    /**
     * Save Officer Personal Info
     *
     * @param newInfo       New info array of admin
     * @param changePass    is change password button enabled
     * @param officer       the current officer object
     */
    public static void savePersonal(String[] newInfo, boolean changePass, Officer officer){
        List<String> lines = new ArrayList<>();
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/com.yoyofurniture.data/officer.txt"));
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(officer.getUserID())) {
                    if (changePass) {
                        parts[1] = HandleAccount.hashString(newInfo[1]);
                    }
                    parts[2] = newInfo[2];
                    parts[3] = newInfo[3];
                    parts[4] = newInfo[4];
                    line = String.join(",", parts);
                }
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/com.yoyofurniture.data/officer.txt"))) {
            for (String line : lines) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Format officer information to string to be stored in to txt file
     * @return prepared officer string
     */
    @Override
    public String formatInfo(){
        return getUserID()+","+getPassword()+","+getName()+","+phoneNumber+","+email;
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
    
    public boolean submitProduction(List<SaleOrder> saleOrderList, String saleID)throws Exception{
        SaleOrder saleOrder = saleOrderList.stream().filter(saleOrder1 -> saleOrder1.getSaleID().equals(saleID))
                .findFirst().get();
        if (saleOrder.getStatus().equals(Status.UNAPPROVED.getStatus()) ||
                saleOrder.getStatus().equals(Status.APPROVED.getStatus()) ||
                saleOrder.getStatus().equals(Status.PENDING.getStatus())) {
            saleOrder.setStatus("PREPARING");
            HandleSales.getHandleSalesInstance().updateExistingOrder(saleOrder);
            return true;
        }
        return false;
    
    }
}
