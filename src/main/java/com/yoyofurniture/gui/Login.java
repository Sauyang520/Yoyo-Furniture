package com.yoyofurniture.gui;

import com.yoyofurniture.bean.Administrator;
import com.yoyofurniture.bean.Officer;
import com.yoyofurniture.bean.Salesperson;
import com.yoyofurniture.bean.User;
import com.yoyofurniture.gui.administrator.AdmMain;
import com.yoyofurniture.gui.officer.OfcMain;
import com.yoyofurniture.gui.salesperson.SpMain;
import com.yoyofurniture.utility.SetRole;

import javax.swing.*;


public class Login extends javax.swing.JFrame {
    private final LoginFunction loginAdmin = Administrator::loginAdmin;
    private final SetRole setAdministrator = userinfo -> (new Administrator(userinfo[0], userinfo[1], userinfo[2]));
    private final SetJPanel jPanelAdm = user -> (new AdmMain((Administrator)user));

    private final LoginFunction loginOfficer = Officer::login;
    private final SetRole setOfficer = userinfo -> new Officer(userinfo[0], userinfo[1], userinfo[2], userinfo[3], userinfo[4]);
    private final SetJPanel jPanelOfc = user -> (new OfcMain((Officer)user));

    private final LoginFunction loginSalesperson = Salesperson::loginSalesperson;
    private final SetRole setSalesperson = userinfo ->
            new Salesperson(userinfo[0], userinfo[1], userinfo[2], userinfo[3], userinfo[4], userinfo[5], userinfo[6]);
    private final SetJPanel jPanelSp = user -> (new SpMain((Salesperson)user));


    public Login() {
        initComponents();
        setTitle("Yoyo Furniture");
        setLocationRelativeTo(null);
        jTextFieldId.setText("YF0001");
        jPasswordFieldPass.setText("1314");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldId = new javax.swing.JTextField();
        jPasswordFieldPass = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButtonOfc = new javax.swing.JButton();
        jButtonSp = new javax.swing.JButton();
        jButtonAdm = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelReminder = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(850, 600));

        jTextFieldId.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("ID");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Yoyo Furniture");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Password");

        jButtonOfc.setText("Officer");
        jButtonOfc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOfcActionPerformed(evt);
            }
        });

        jButtonSp.setText("Salesperson");
        jButtonSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSpActionPerformed(evt);
            }
        });

        jButtonAdm.setText("Administrator");
        jButtonAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdmActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOGIN AS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(207, Short.MAX_VALUE)
                .addComponent(jButtonAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonOfc, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButtonSp, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(190, 190, 190))
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOfc)
                    .addComponent(jButtonSp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAdm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabelReminder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordFieldPass, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelReminder, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGap(220, 220, 220))
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordFieldPass, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addComponent(jLabelReminder, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButtonOfcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOfcActionPerformed
        handleLogin(loginOfficer, setOfficer, jPanelOfc);
    }//GEN-LAST:event_jButtonOfcActionPerformed

    private void jButtonSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSpActionPerformed
        handleLogin(loginSalesperson, setSalesperson, jPanelSp);
    }//GEN-LAST:event_jButtonSpActionPerformed

    private void jButtonAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdmActionPerformed
        handleLogin(loginAdmin, setAdministrator, jPanelAdm);
    }//GEN-LAST:event_jButtonAdmActionPerformed


    /**
     * Handle login function
     * @param loginFunction OverWrite login function for different role
     * @param setRole create new user object for different role
     * @param enterpage enter page for different role when login successful
     */
    private void handleLogin(LoginFunction loginFunction, SetRole setRole, SetJPanel enterpage) {
        String userId = jTextFieldId.getText();
        String password = String.valueOf(jPasswordFieldPass.getPassword());
        String[] userinfo = loginFunction.login(userId, password);

        if (userinfo != null) {
            try {
                getContentPane().removeAll();
                setContentPane(enterpage.enterPage(setRole.setRole(userinfo)));
                revalidate();
                repaint();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            jLabelReminder.setText("Incorrect Information. Please try again.");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdm;
    private javax.swing.JButton jButtonOfc;
    private javax.swing.JButton jButtonSp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelReminder;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordFieldPass;
    private javax.swing.JTextField jTextFieldId;
    // End of variables declaration//GEN-END:variables
}


interface LoginFunction {
    String[] login(String username, String password);
}

interface SetJPanel {
    JPanel enterPage(User user);
}