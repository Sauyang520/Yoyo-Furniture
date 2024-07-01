package com.yoyofurniture.gui.officer;


import com.yoyofurniture.bean.SaleOrder;
import com.yoyofurniture.bean.Officer;
import com.yoyofurniture.bean.OrderEntry;
import com.yoyofurniture.bean.Product;
import com.yoyofurniture.bean.SelectedProduct;
import com.yoyofurniture.bean.Status;

import com.yoyofurniture.gui.SalesOrderUpdates;
import com.yoyofurniture.utility.HandleSales;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;


public class OfcCheckProductStatus extends javax.swing.JPanel {
    private final Officer officer;
    private final List<SaleOrder> saleOrderList = new ArrayList<>();
    private DefaultTableModel jTableModel;
    private final List<SaleOrder> selectedOrders = new ArrayList<>();
    private final List<OrderEntry> orderEntries = new ArrayList<>();

    public OfcCheckProductStatus(Officer officer) {
        this.officer = officer;
        initComponents();
        selfInitComponents();
        
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSaleOrder = new javax.swing.JTable();
        jTextFieldSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonMenu = new javax.swing.JButton();
        jButtonDetails = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jStatusComboBox1 = new javax.swing.JComboBox<>();
        jResetButton = new javax.swing.JButton();

        jTableSaleOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableSaleOrder.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableSaleOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSaleOrderMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableSaleOrder);

        jTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyReleased(evt);
            }
        });

        jLabel1.setText("Search By ID:");

        jButtonMenu.setText("Menu");
        jButtonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuActionPerformed(evt);
            }
        });

        jButtonDetails.setText("Modify Record");
        jButtonDetails.setEnabled(false);
        jButtonDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDetailsActionPerformed(evt);
            }
        });

        jLabel3.setText("Filter By Sale Product Status:");

        jStatusComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        jStatusComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jStatusComboBox1ActionPerformed(evt);
            }
        });

        jResetButton.setText("Clear Filters");
        jResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jResetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButtonMenu)
                                .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(52, 52, 52)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jStatusComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jResetButton))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE)))))
                    .addComponent(jButtonDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jButtonMenu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatusComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jResetButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDetailsActionPerformed
        int selectedRow = jTableSaleOrder.getSelectedRow();

        if (selectedRow != -1) {
            String saleID = jTableSaleOrder.getValueAt(selectedRow, 0).toString();

            SaleOrder saleOrder = saleOrderList.stream().filter(saleOrder1 -> saleOrder1.getSaleID().equals(saleID))
                    .findFirst().get();
            
            SalesOrderUpdates salesOrderDetail2 = new SalesOrderUpdates(saleOrder);
            salesOrderDetail2.setVisible(true);
            salesOrderDetail2.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    // Refresh the table after the SalesOrderDetail2 window is closed
                    selfInitComponents();
                }
            });       
        }
    }//GEN-LAST:event_jButtonDetailsActionPerformed

    private void jButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuActionPerformed
        enterFunction(new OfcMain(officer));
    }//GEN-LAST:event_jButtonMenuActionPerformed

    private void jTextFieldSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyReleased
        handleSearch();
    }//GEN-LAST:event_jTextFieldSearchKeyReleased

    private void jStatusComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jStatusComboBox1ActionPerformed
        handleSearch();
    }//GEN-LAST:event_jStatusComboBox1ActionPerformed

    private void jResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jResetButtonActionPerformed
        resetTableToDefault();
        

        // Clear all search bars and combo boxes to "None"
        jTextFieldSearch.setText("");
        
        jStatusComboBox1.setSelectedItem("None");
    }//GEN-LAST:event_jResetButtonActionPerformed

    private void jTableSaleOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSaleOrderMouseClicked
        jButtonDetails.setEnabled(true);
        
    }//GEN-LAST:event_jTableSaleOrderMouseClicked
    
    private void handleSearch(){
        List<OrderEntry> orderEntrys = new ArrayList<>(orderEntries);
        jTableModel.setRowCount(0);

        String searchKeywordID = jTextFieldSearch.getText();
        
        final String selectedFinalStatus;
        String selectedStatus = String.valueOf(jStatusComboBox1.getSelectedItem());
        if (selectedStatus.equals("None")){
            selectedFinalStatus = "";
        } else if(selectedStatus.equals("NOT_STARTED")){
            selectedFinalStatus = "APPROVED";
        }
        else {
            selectedFinalStatus = selectedStatus;   
        }   

        orderEntrys.stream().filter(orderEntry -> orderEntry.getSaleID().contains(searchKeywordID) &&
                orderEntry.getStatus().contains(selectedFinalStatus))
                .sorted((o1, o2) -> Integer.parseInt(o2.getSaleID().substring(2)) -
                        Integer.parseInt(o1.getSaleID().substring(2)))
                .forEach(order -> insertData(order.getSaleID(), order.getProduct().getItemID(),order.getProduct().getItemName(),order.getProduct().getItemCategory(),String.valueOf(order.getQuantity()), order.getSaleDateTime(),
                      order.getStatus()));

        jTableModel.fireTableDataChanged();
    }

    /**
     * refresh current panel when deleting salesperson
     */
    private void refreshScreenWhenDelete() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(jTableSaleOrder);
        if (frame != null) {
            frame.getContentPane().removeAll();
            frame.setContentPane(new OfcCheckProductStatus(officer));
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        }
    }

    /**
     * insert row to table
     * @param saleOderID sale order id
     * @param custID customer id
     * @param dateTime date time
     * @param total total
     * @param status status
     */
    private void insertData(String saleOderID, String itemID, String itemName, String description,String quantity,String dateTime, String status) {
        // Add a row with the provided data to the DefaultTableModel
        String newstatus;
        if (status.equals("APPROVED")) {
              newstatus = "NOT_STARTED";
            } else{
            newstatus = status;
        }
        jTableModel.addRow(new Object[]{saleOderID, itemID, itemName, description, quantity,dateTime, newstatus});
    }

    /**
     * Switch scene (panel)
     * @param jPanel panel to be switched
     */
    private void enterFunction(JPanel jPanel) {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (frame != null) {
            frame.getContentPane().removeAll();
            frame.setContentPane(jPanel);
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        }
    }
    private void selfInitComponents() {
        jTableModel = new DefaultTableModel(new Object[]{"Sale ID", "Item ID", "Item Name","Description","Quantity", "Date Time", "Status"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        jTableSaleOrder.setModel(jTableModel);
        
        String[] allStatuses = Status.getAllStatuses();
        for (String status : allStatuses) {
            if (status.equals("WORK_DONE") || status.equals("PREPARING")) {
                jStatusComboBox1.addItem(status);
            } else if (status.equals("APPROVED")){
                String newstatus = "NOT_STARTED";
                jStatusComboBox1.addItem(newstatus);
            }
                        
            }
        saleOrderList.clear();
        selectedOrders.clear();
        orderEntries.clear();
        try {
            saleOrderList.addAll(HandleSales.readAllSalesOrder());
            for (SaleOrder saleorder : saleOrderList) {
                if (saleorder.getStatus().equals("WORK_DONE")||saleorder.getStatus().equals("APPROVED")||saleorder.getStatus().equals("PREPARING")){
                    System.out.println(saleorder.getSaleID());
                    System.out.println(saleorder.getProductList());
                    selectedOrders.add(saleorder);
                }
            }    
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try{
            for (SaleOrder order:selectedOrders){
               String saleID = order.getSaleID();
               String salesperson = order.getSalesperson();
               String saleDateTime = order.getSaleDateTime();
               String status = order.getStatus();
               

               for (SelectedProduct selectedProduct : order.getProductList()) {
                   Product product = selectedProduct.getProduct();
                   int quantity = selectedProduct.getQuantity();
                   double amount = selectedProduct.getAmount();
                   String itemID = product.getItemID();
                   String itemName = product.getItemName();
                   
                   

                   // Create a new OrderEntry for each SelectedProduct
                   OrderEntry orderEntry = new OrderEntry(saleID, salesperson, saleDateTime, product, quantity, amount,status);
                   orderEntries.add(orderEntry); // Add the OrderEntry to the list
                   }
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        resetTableToDefault();
    }
    
    private void resetTableToDefault() {
        
        
        // Clear the table
        jTableModel.setRowCount(0);

        
        
        List<OrderEntry> orderEntrys = new ArrayList<>(orderEntries);
        orderEntrys.stream()
                .sorted((o1, o2) -> Integer.parseInt(o2.getSaleID().substring(2)) -
                        Integer.parseInt(o1.getSaleID().substring(2)))
                .forEach(order -> insertData(order.getSaleID(), order.getProduct().getItemID(),order.getProduct().getItemName(),order.getProduct().getItemCategory(),String.valueOf(order.getQuantity()), order.getSaleDateTime(),
                      order.getStatus()));

        // Refresh the table
        jTableModel.fireTableDataChanged();
        jButtonDetails.setEnabled(false);
        
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDetails;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jResetButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jStatusComboBox1;
    private javax.swing.JTable jTableSaleOrder;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables
}