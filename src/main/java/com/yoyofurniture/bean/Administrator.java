package com.yoyofurniture.bean;

import com.yoyofurniture.utility.HandleAccount;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Administrator extends User {
    public Administrator(String userID, String password, String name) {
        super(userID, password, name);
    }


    /**
     * Login function for administrator
     *
     * @param userID   the entered user ID
     * @param password the entered password
     * @return true: the ID and password match text file, false: either ID or password or both incorrect
     */
    public static String[] loginAdmin(String userID, String password) {
        return User.login("administrator.txt", userID, password);
    }

    /**
     * Save Admin Personal Info
     *
     * @param newInfo       New info array of admin
     * @param changePass    is change password button enabled
     * @param administrator the current administrator object
     */
    public static void savePersonal(String[] newInfo, boolean changePass, Administrator administrator) {
        List<String> lines = new ArrayList<>();
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/com.yoyofurniture.data/administrator.txt"));
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(administrator.getUserID())) {
                    parts[0] = newInfo[0];
                    if (changePass) {
                        parts[1] = HandleAccount.hashString(newInfo[1]);
                    }
                    parts[2] = newInfo[2];
                    line = String.join(",", parts);
                }
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/com.yoyofurniture.data/administrator.txt"))) {
            for (String line : lines) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete officer
     * @param userID the officer user id to be deleted
     * @throws Exception exception
     */
    public static void deleteOfc(String userID) throws Exception {
        List<Officer> officerList = new ArrayList<>(HandleAccount.readAllData("officer.txt", userinfo
                        -> new Officer(userinfo[0], userinfo[1], userinfo[2], userinfo[3], userinfo[4]), ",").stream()
                        .map(user -> (Officer) user).filter(o -> !o.getUserID().equals(userID)).toList());

        List<String> officerStringList = new ArrayList<>();
        officerList.forEach(o -> officerStringList.add(o.formatInfo()));

        HandleAccount.writeAllData("officer.txt", officerStringList);
    }

    /**
     * Add new officer
     * @param user joined user information string with ","
     * @param newID new id sting array
     * @throws Exception exception
     */
    public static void addOfc(String user, String[] newID) throws Exception {
        HandleAccount.addData("officer.txt", user);
        HandleAccount.writeAllData("id.txt", new ArrayList<>(List.of(String.join(",", newID))));
    }

    /**
     * Delete Salesperson (Not recommend to use this function)
     * @param userID salesperson id to be deleted
     * @throws Exception exception
     */
    public static void deleteSp(String userID) throws Exception {
        List<Salesperson> salespersonList = new ArrayList<>(HandleAccount.readAllData("salesperson.txt", userinfo
                        -> new Salesperson(userinfo[0], userinfo[1], userinfo[2], userinfo[3], userinfo[4], userinfo[5], userinfo[6]), ",")
                .stream().map(user -> (Salesperson) user).filter(s -> !s.getUserID().equals(userID)).toList());

        List<String> salespersonStringList = new ArrayList<>();
        salespersonList.forEach(o -> salespersonStringList.add(o.formatInfo()));

        HandleAccount.writeAllData("salesperson.txt", salespersonStringList);
    }

    /**
     * Add new Salesperson
     * @param user joined user information string with ","
     * @param newID new id String array
     * @throws Exception exception
     */
    public static void addSp(String user, String[] newID) throws Exception {
        HandleAccount.addData("salesperson.txt", user);
        HandleAccount.writeAllData("id.txt", new ArrayList<>(List.of(String.join(",", newID))));
    }

    /**
     * Format administrator information to string to be stored in to txt file
     * @return prepared officer string
     */
    @Override
    public String formatInfo() {
        return getUserID()+","+getPassword()+","+getName();
    }
}
