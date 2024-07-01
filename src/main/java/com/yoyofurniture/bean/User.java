package com.yoyofurniture.bean;

import com.yoyofurniture.utility.HandleAccount;
import java.io.BufferedReader;
import java.io.FileReader;

public abstract class User implements UserManual{
    private String userID;
    private String password;
    private String name;

    public User() {
    }


    public User(String userID, String password, String name) {
        this.userID = userID;
        this.password = password;
        this.name = name;
    }

    /**
     * Login function
     * @param filename to search for which role
     * @param userID user id to login
     * @param password user password to verify
     * @return user information if login successful, else null
     */
    public static String[] login(String filename, String userID, String password) {
        try (
                FileReader reader = new FileReader("src/main/resources/com.yoyofurniture.data/" + filename);
                BufferedReader bufferedReader = new BufferedReader(reader)
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] userinfo = line.split(",");
                // index 0: ID, index 1: Hashed Password
                if (userinfo[0].equals(userID) && userinfo[1].equals(HandleAccount.hashString(password))) {
                    return userinfo;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
