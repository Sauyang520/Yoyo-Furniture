package com.yoyofurniture.gui.administrator;

import com.yoyofurniture.bean.Administrator;
import com.yoyofurniture.gui.Login;

import javax.swing.*;


public class AdmMain extends javax.swing.JPanel {
    private final Administrator administrator;

    public AdmMain(Administrator administrator) {
        initComponents();
        this.administrator = administrator;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("checked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jButtonReport = new javax.swing.JButton();
        jButtonOfficer = new javax.swing.JButton();
        jButtonSalesperson = new javax.swing.JButton();
        jButtonLogout = new javax.swing.JButton();
        jButtonPersonal = new javax.swing.JButton();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jButtonReport.setText("Report");
        jButtonReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReportActionPerformed(evt);
            }
        });

        jButtonOfficer.setText("Manage Officer");
        jButtonOfficer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOfficerActionPerformed(evt);
            }
        });

        jButtonSalesperson.setText("Manage Salesperson");
        jButtonSalesperson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalespersonActionPerformed(evt);
            }
        });

        jButtonLogout.setText("Logout");
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });

        jButtonPersonal.setText("Edit Personal Profile");
        jButtonPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPersonalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(351, 351, 351)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(jButtonLogout)
                                        .addComponent(jButtonPersonal)
                                        .addComponent(jButtonReport)
                                        .addComponent(jButtonOfficer)
                                        .addComponent(jButtonSalesperson))
                                .addContainerGap(359, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addComponent(jButtonReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(39, 39, 39)
                                .addComponent(jButtonOfficer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(32, 32, 32)
                                .addComponent(jButtonSalesperson, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(28, 28, 28)
                                .addComponent(jButtonPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(33, 33, 33)
                                .addComponent(jButtonLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(200, 200, 200))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReportActionPerformed
        AdmGenerateReport report = new AdmGenerateReport(administrator);
        report.setVisible(true);
    }//GEN-LAST:event_jButtonReportActionPerformed

    private void jButtonOfficerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOfficerActionPerformed
        enterFunction(new AdmManageOfc(administrator));
    }//GEN-LAST:event_jButtonOfficerActionPerformed

    private void jButtonSalespersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalespersonActionPerformed
        enterFunction(new AdmManageSp(administrator));
    }//GEN-LAST:event_jButtonSalespersonActionPerformed

    private void jButtonPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPersonalActionPerformed
        enterFunction(new AdmManagePersonal(administrator));
    }//GEN-LAST:event_jButtonPersonalActionPerformed

    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (frame != null) {
            frame.dispose();
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_jButtonLogoutActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonOfficer;
    private javax.swing.JButton jButtonPersonal;
    private javax.swing.JButton jButtonReport;
    private javax.swing.JButton jButtonSalesperson;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu jPopupMenu1;
    // End of variables declaration//GEN-END:variables
}