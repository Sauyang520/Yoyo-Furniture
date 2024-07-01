package com.yoyofurniture.utility;

import com.yoyofurniture.bean.*;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class HandleSales {
    private HandleSales() {
    }

    public static HandleSales getHandleSalesInstance() {
        if (handleSales == null) {
            handleSales = new HandleSales();
            return handleSales;
        }
        return handleSales;
    }

    private static HandleSales handleSales;

    private final List<SelectedProduct> cart = new ArrayList<>();



    public static void deleteHandleSalesInstance() {
        handleSales = null;
    }


    /**
     * Get all product list from csv file
     *
     * @return list of products
     * @throws Exception exception
     */
    public static List<Product> readAllProduct() throws Exception {
        FileReader fileReader = new FileReader("src/main/resources/com.yoyofurniture.data/IKEA_SA_Furniture_Web_Scrapings_sss.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<Product> productList = new ArrayList<>();
        bufferedReader.readLine();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(",");
            String itemID = data[0];
            String itemName = data[1];
            String itemCategory = data[2];
            double itemPrice = Double.parseDouble(data[3]);
            String itemDescription = data[4];
            String itemDesigner = data[5];
            String itemDepth = data[6];
            String itemHeight = data[7];
            String itemWidth = data[8];
            Product product = new Product(itemID, itemName, itemCategory, itemPrice, itemDescription, itemDesigner, itemDepth, itemHeight, itemWidth);
            productList.add(product);
        }
        return productList;
    }

    public List<SelectedProduct> getCart() {
        return cart;
    }

    /**
     * Add item to the cart
     *
     * @param product  product
     * @param quantity quantity
     */
    public void addItemToCart(Product product, int quantity) {
        Optional<SelectedProduct> existingProduct = cart.stream()
                .filter(sp -> sp.getProduct().getItemID().equals(product.getItemID()))
                .findFirst();

        if (existingProduct.isPresent()) {
            SelectedProduct repeatedSelectedProduct = existingProduct.get();
            cart.remove(repeatedSelectedProduct);
            int newQuantity = quantity + repeatedSelectedProduct.getQuantity();
            cart.add(new SelectedProduct(product, newQuantity));
        } else {
            cart.add(new SelectedProduct(product, quantity));
        }
    }

    /**
     * Calculate new total when quantity change or product removed
     *
     * @return new total
     */
    public double calculateTotal() {
        return cart.stream()
                .mapToDouble(SelectedProduct::getAmount)
                .sum();
    }

    /**
     * Generate new ID for Sale Order only
     *
     * @return id string array
     * @throws IOException exception
     */
    public static String[] generateNewID() throws IOException {
        FileReader fileReader = new FileReader("src/main/resources/com.yoyofurniture.data/id.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String[] id = bufferedReader.readLine().split(",");

        String prefix = id[ID.SALESORDER_ID.getIndex()].substring(0, 2);
        String numericPart = id[ID.SALESORDER_ID.getIndex()].substring(2);

        int numericValue = Integer.parseInt(numericPart);
        numericValue++;
        String newNumericPart = String.format("%06d", numericValue);
        id[ID.SALESORDER_ID.getIndex()] = prefix + newNumericPart;

        return id;
    }

    /**
     * Overwrite all data to file
     * @param filename txt file
     * @param list string list to be written
     * @throws Exception exception
     */
    public static void writeAllData(String filename, List<String> list) throws Exception {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/com.yoyofurniture.data/" + filename))) {
            for (String l : list) {
                bufferedWriter.write(l);
                bufferedWriter.newLine();
            }
        }
    }

    /**
     * Save all the sales order to txt file
     * @param saleOrders list of all sales order
     * @throws Exception exception
     */
    public void saveAllSalesOrder(List<SaleOrder> saleOrders) throws Exception {
        List<String> saleOrderString = new ArrayList<>();
        for (SaleOrder saleOrder : saleOrders) {
            saleOrderString.add(saleOrder.formatNewInfo());
        }

        writeAllData("salesorder.txt", saleOrderString);
    }

    /**
     * Add new record
     * @param filename txt file
     * @param data string data
     * @throws Exception exception
     */
    public static void addData(String filename, String data) throws Exception {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/com.yoyofurniture.data/" + filename, true))) {
            bufferedWriter.write(data);
            bufferedWriter.newLine();
        }
    }

    /**
     * Place new order
     * @param salesperson salesperson in charged
     * @param selectedCustID customer id
     * @throws Exception exception
     */
    public void placeNewOrder(Salesperson salesperson, String selectedCustID) throws Exception {
        String[] ID = generateNewID();
        String newID = ID[com.yoyofurniture.utility.ID.SALESORDER_ID.getIndex()];
        String now = localDateTimeToString(LocalDateTime.now());
        double total = calculateTotal();
        String status = Status.PENDING.name();

        SaleOrder saleOrder = new SaleOrder(newID, salesperson.getUserID(), selectedCustID, now, new ArrayList<>(cart), total, status);

        addData("salesorder.txt", saleOrder.formatInfo());
        writeAllData("id.txt", new ArrayList<>(List.of(String.join(",", ID))));

        deleteHandleSalesInstance();
    }
    
    public void updateExistingOrder(SaleOrder saleOrder){
        List<String> updatedLines = new ArrayList<>();
        try (
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/com.yoyofurniture.data/salesorder.txt"));
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(saleOrder.getSaleID())) {
                    String updatedLine = saleOrder.formatNewInfo();
                    updatedLines.add(updatedLine);
                } else {
                    updatedLines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        try (
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/com.yoyofurniture.data/salesorder.txt"));
        ) {
            for (String updatedLine : updatedLines) {
                writer.write(updatedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get all sales order
     * @return list of sales order
     * @throws Exception exception
     */
    public static List<SaleOrder> readAllSalesOrder() throws Exception {
        List<Product> productList = readAllProduct();

        FileReader fileReader = new FileReader("src/main/resources/com.yoyofurniture.data/salesorder.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<SaleOrder> saleOrderList = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(",");
            String[] list = data[4].split("\\|");
            List<SelectedProduct> selectedProductList = parseSelectedProducts(list, productList);

            saleOrderList.add(new SaleOrder(data[0], data[1], data[2], data[3], selectedProductList, Double.parseDouble(data[5]), data[6]));
        }
        return saleOrderList;
    }
    
    public static SaleOrder getSaleOrderByID(String saleID) throws Exception {
    List<Product> productList = readAllProduct();
    
    FileReader fileReader = new FileReader("src/main/resources/com.yoyofurniture.data/salesorder.txt");
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    
    String line;
    while ((line = bufferedReader.readLine()) != null) {
        String[] data = line.split(",");
        if (data[0].equals(saleID)) {
            String[] list = data[4].split("\\|");
            List<SelectedProduct> selectedProductList = parseSelectedProducts(list, productList);
            
            return new SaleOrder(data[0], data[1], data[2], data[3], selectedProductList, Double.parseDouble(data[5]), data[6]);
        }
    }
    
    // If sale ID is not found, return null or throw an exception
    return null; // or throw new Exception("SaleOrder with ID " + saleID + " not found");
}

    /**
     * Parse string to selected product for readAllSalesOrder function
     * @param productList list of product in string
     * @param allProducts list of all product
     * @return list of selected product
     */
    private static List<SelectedProduct> parseSelectedProducts(String[] productList, List<Product> allProducts) {
        return Arrays.stream(productList)
                .map(s -> {
                    String[] product = s.split("#");
                    Product product1 = allProducts.stream().filter(p -> p.getItemID().equals(product[0])).findFirst().orElse(null);
                    return (product1 != null) ? new SelectedProduct(product1, Integer.parseInt(product[1])) : null;
                })
                .filter(Objects::nonNull)
                .toList();
    }

    /**
     * Convert LocalDateTime to String
     * @param localDateTime LocalDateTime
     * @return String
     */
    public static String localDateTimeToString(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        return localDateTime.format(formatter);
    }

    /**
     * Convert String to LocalDateTime
     * @param string String
     * @return LocalDateTime
     */
    public static LocalDateTime stringToLocalDateTime(String string) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        return LocalDateTime.parse(string, formatter);
    }
}
