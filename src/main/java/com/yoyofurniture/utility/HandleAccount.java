package com.yoyofurniture.utility;


import com.yoyofurniture.bean.User;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class HandleAccount {
    private HandleAccount() {
    }

    /**
     * Encode the password to enhance security
     * @param input input string
     * @return hashed string
     */
    public static String hashString(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));

            // Convert the byte array to a hexadecimal string representation
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace(); // Handle the exception appropriately
            return null;
        }
    }

    /**
     * Compare two password whether same or not
     * @param password1 password 1
     * @param password2 password 2
     * @return true if both passwords are same, vice versa
     */
    public static boolean comparePassword(String password1, String password2) {
        return password1.equals(password2);
    }

    /**
     * validate password format
     * @param newPassword password to be validated
     * @return true is format correct, vice versa
     */
    public static boolean validateNewPassword(String newPassword) {
        String passwordFormat = "^(?=.*[A-Z])(?=.*[!@#$%^&*()-_=+]).{8,}$";
        return newPassword.matches(passwordFormat);
    }

    /**
     * Validate email format
     * @param email email to be validated
     * @return true if format is correct, vice versa
     */
    public static boolean validateEmail(String email) {
        String emailFormat = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailFormat);
    }

    /**
     * Validate phone number format as Malaysia
     * @param phone phone number to be validated
     * @return true if format is correct, vice versa
     */
    public static boolean validatePhone(String phone) {
        String phoneFormat = "^(?:(?:\\+|00)60|0)([1-9]\\d{8,9})$";
        return phone.matches(phoneFormat);
    }

    /**
     * Validate the age of salesperson, the age must be 18 or above
     * @param localDate date of birth
     * @param age age is 18
     * @return true if age >= 18
     */
    public static boolean validateBOD(LocalDate localDate, int age) {
        return Period.between(localDate, LocalDate.now()).getYears() >= age;
    }

    /**
     * Convert LocalDate to String with DateTimeFormatter
     * @param localDate LocalDate
     * @return LocalDate String
     */
    public static String localDateToString(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return localDate.format(formatter);
    }

    /**
     * Convert String to LocalDate with DateTimeFormatter
     * @param date String date
     * @return LocalDate date
     */
    public static LocalDate stringToLocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, formatter);
    }

    /**
     * Check if there is repeated element in file
     * @param filename txt file to search
     * @param oldStr old element
     * @param newStr element to replace
     * @param index which element
     * @return true id repeated, vice versa
     * @throws Exception exception
     */
    public static boolean checkRepeatedElement(String filename, String oldStr, String newStr, int index) throws Exception {
        FileReader fileReader = new FileReader("src/main/resources/com.yoyofurniture.data/" + filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] parts = line.split(",");
            if (!parts[index].equals(oldStr) && parts[index].equals(newStr)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Read all data from txt file
     * @param filename txt file
     * @param setRole convert the element to user object with different role
     * @param split delimiter
     * @return list of selected role
     * @throws Exception exception
     */
    public static List<User> readAllData(String filename, SetRole setRole, String split) throws Exception {
        FileReader fileReader = new FileReader("src/main/resources/com.yoyofurniture.data/" + filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<User> userList = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(split);
            User user = setRole.setRole(data);
            userList.add(user);
        }
        return userList;
    }

    /**
     * Overwrite all data to file
     * @param filename txt file
     * @param userList string list to be written
     * @throws Exception exception
     */
    public static void writeAllData(String filename, List<String> userList) throws Exception {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/com.yoyofurniture.data/" + filename))) {
            for (String user : userList) {
                bufferedWriter.write(user);
                bufferedWriter.newLine();
            }
        }
    }

    /**
     * add new record to file
     * @param filename txt file
     * @param data String to be written
     * @throws Exception exception
     */
    public static void addData(String filename, String data) throws Exception {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/com.yoyofurniture.data/" + filename, true))) {
            bufferedWriter.write(data);
            bufferedWriter.newLine();
        }
    }

    /**
     * Generate new ID
     * @param idType which role of ID to be generated
     * @return id string array
     * @throws IOException exception
     */
    public static String[] generateNewID(ID idType) throws IOException {
        FileReader fileReader = new FileReader("src/main/resources/com.yoyofurniture.data/id.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String[] id = bufferedReader.readLine().split(",");

        String prefix = id[idType.getIndex()].substring(0, 2);
        String numericPart = id[idType.getIndex()].substring(2);

        int numericValue = Integer.parseInt(numericPart);
        numericValue++;
        String newNumericPart = String.format("%04d", numericValue);
        id[idType.getIndex()] = prefix + newNumericPart;

        return id;
    }

    /**
     * convert Date to LocalDate
     * @param dateToParse date
     * @return LocalDate
     */
    public static LocalDate convertDateToLocalDate(Date dateToParse) {
        return dateToParse.toInstant().atZone(ZoneId.of("Asia/Kuala_Lumpur")).toLocalDate();
    }

    /**
     * convert LocalDate to Date
     * @param localDateToConvert LocalDate
     * @return Date
     */
    public static Date convertLocalDateToDate(LocalDate localDateToConvert) {
        return Date.from(localDateToConvert.atStartOfDay(ZoneId.of("Asia/Kuala_Lumpur")).toInstant());
    }
}