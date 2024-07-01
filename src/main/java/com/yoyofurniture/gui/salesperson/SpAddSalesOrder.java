package com.yoyofurniture.gui.salesperson;

import com.yoyofurniture.bean.Product;
import com.yoyofurniture.bean.Salesperson;

import com.yoyofurniture.utility.HandleSales;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;


public class SpAddSalesOrder extends javax.swing.JPanel {
    private final Salesperson salesperson;
    private final List<Product> productList = new ArrayList<>();
    private DefaultTableModel jTableModel;

    public SpAddSalesOrder(Salesperson salesperson) {
        this.salesperson = salesperson;
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
        jTableProduct = new javax.swing.JTable();
        jRadioButtonId = new javax.swing.JRadioButton();
        jRadioButtonCategory = new javax.swing.JRadioButton();
        jRadioButtonName = new javax.swing.JRadioButton();
        jTextFieldSearch = new javax.swing.JTextField();
        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
        jSpinnerAmount = new javax.swing.JSpinner(spinnerModel);
        jLabel1 = new javax.swing.JLabel();
        jButtonAdd = new javax.swing.JButton();
        jButtonCart = new javax.swing.JButton();
        jButtonDetails = new javax.swing.JButton();
        jButtonMenu = new javax.swing.JButton();

        jTableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableProduct.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableProduct.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableProduct);

        jRadioButtonId.setText("ID");

        jRadioButtonCategory.setText("Category");

        jRadioButtonName.setText("Name");

        jTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyReleased(evt);
            }
        });

        jLabel1.setText("Quantity");

        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonCart.setText("Cart");
        jButtonCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCartActionPerformed(evt);
            }
        });

        jButtonDetails.setText("Details");
        jButtonDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDetailsActionPerformed(evt);
            }
        });

        jButtonMenu.setText("Menu");
        jButtonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonMenu)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jSpinnerAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonAdd))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioButtonId)
                                        .addGap(38, 38, 38)
                                        .addComponent(jRadioButtonName)
                                        .addGap(44, 44, 44)
                                        .addComponent(jRadioButtonCategory))
                                    .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonCart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonDetails, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(103, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jButtonMenu)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonId)
                    .addComponent(jRadioButtonCategory)
                    .addComponent(jRadioButtonName))
                .addGap(18, 18, 18)
                .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jSpinnerAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jButtonAdd))
                    .addComponent(jButtonCart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(66, 66, 66))
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jButtonDetails)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldSearchKeyReleased(KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyReleased
        List<Product> products = new ArrayList<>();
        jTableModel.setRowCount(0);
        String text = jTextFieldSearch.getText();

        if (text.equals("")) {
            products.addAll(productList);
        } else {
            if (jRadioButtonId.isSelected()) {
                products.addAll(productList.stream()
                        .filter(p -> p.getItemID().toUpperCase().contains(text.toUpperCase()))
                        .toList());
            } else if (jRadioButtonName.isSelected()) {
                products.addAll(productList.stream()
                        .filter(p -> p.getItemName().toUpperCase().contains(text.toUpperCase()))
                        .toList());
            } else if (jRadioButtonCategory.isSelected()) {
                products.addAll(productList.stream()
                        .filter(p -> p.getItemCategory().toUpperCase().contains(text.toUpperCase()))
                        .toList());
            } else {
                products.addAll(productList);
            }
        }

        products.forEach(product -> insertData(product.getItemID(), product.getItemName(),
                product.getItemCategory(), product.getItemPrice()));

        jTableModel.fireTableDataChanged();
    }//GEN-LAST:event_jTextFieldSearchKeyReleased

    private void jButtonCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCartActionPerformed
        enterFunction(new SpCart(salesperson));
    }//GEN-LAST:event_jButtonCartActionPerformed

    private void jButtonDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDetailsActionPerformed
        int selectedRow = jTableProduct.getSelectedRow();

        if (selectedRow != -1) {
            String itemID = jTableProduct.getValueAt(selectedRow, 0).toString();
            Product product = productList.stream().filter(p -> p.getItemID().equals(itemID)).toList().get(0);
            new SpProductDetails(product).setVisible(true);
        }
    }//GEN-LAST:event_jButtonDetailsActionPerformed

    private void jButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuActionPerformed
        enterFunction(new SpMain(salesperson));
    }//GEN-LAST:event_jButtonMenuActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        int selectedRow = jTableProduct.getSelectedRow();
        if (selectedRow != -1) {
            String itemID = jTableProduct.getValueAt(selectedRow, 0).toString();
            int quantity = (int)jSpinnerAmount.getValue();
            Product product = productList.stream().filter(p -> p.getItemID().equals(itemID)).toList().get(0);

            salesperson.addItemToCart(product, quantity);
        }

        if (HandleSales.getHandleSalesInstance().getCart().size() > 0){
            jButtonCart.setEnabled(true);
        }
    }//GEN-LAST:event_jButtonAddActionPerformed

    /**
     * Switch scene (panel)
     * @param jPanel panel to be switched
     */
    private void enterFunction(JPanel jPanel){
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (frame != null) {
            frame.getContentPane().removeAll();
            frame.setContentPane(jPanel);
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        }
    }

    /**
     * Insert row to table
     * @param itemID item id
     * @param itemName item name
     * @param itemCategory item category
     * @param itemPrice item price
     */
    private void insertData(String itemID, String itemName, String itemCategory, double itemPrice) {
        // Add a row with the provided data to the DefaultTableModel
        jTableModel.addRow(new Object[]{itemID, itemName, itemCategory, itemPrice});
    }
    private void selfInitComponents() {
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButtonId);
        buttonGroup.add(jRadioButtonName);
        buttonGroup.add(jRadioButtonCategory);

        jTableModel = new DefaultTableModel(new Object[]{"ID", "Name", "Category", "Price"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        jTableProduct.setModel(jTableModel);

        try {
            productList.addAll(HandleSales.readAllProduct());
        } catch (Exception e) {
            e.printStackTrace();
        }

        productList.forEach(product -> insertData(product.getItemID(), product.getItemName(), product.getItemCategory(),
                product.getItemPrice()));

        if (HandleSales.getHandleSalesInstance().getCart().size() == 0){
            jButtonCart.setEnabled(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonCart;
    private javax.swing.JButton jButtonDetails;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButtonCategory;
    private javax.swing.JRadioButton jRadioButtonId;
    private javax.swing.JRadioButton jRadioButtonName;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerAmount;
    private javax.swing.JTable jTableProduct;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables
}
