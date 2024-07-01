package com.yoyofurniture.gui.salesperson;

import com.yoyofurniture.bean.Gender;
import com.yoyofurniture.bean.Salesperson;
import com.yoyofurniture.utility.HandleAccount;
import java.awt.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;


public class SpManagePersonal extends javax.swing.JFrame {
    private static SpManagePersonal currentInstance;
    private final Salesperson salesperson;

    private SpManagePersonal(Salesperson salesperson) {
        this.salesperson = salesperson;
        initComponents();
        selfInitComponents();
        setTitle("Edit Profile Page");
        setLocationRelativeTo(null);

        jResetButton1ActionPerformed(null);
    }

    /**
     * Singleton structure
     * @return SpManagePersonal
     */
    public static SpManagePersonal initiateSpManagePersonal(Salesperson salesperson){
        if (currentInstance == null) {
            currentInstance = new SpManagePersonal(salesperson);
        }
        return currentInstance;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonDiscard = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonSave = new javax.swing.JButton();
        jTextFieldId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jToggleButtonEnablePass = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPasswordFieldCurrent = new javax.swing.JPasswordField();
        jTextFieldPhone = new javax.swing.JTextField();
        jPasswordFieldNew = new javax.swing.JPasswordField();
        jTextFieldEmail = new javax.swing.JTextField();
        jPasswordFieldReEnter = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxGender = new javax.swing.JComboBox<Gender>();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jLabelWarning = new javax.swing.JLabel();
        jResetButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonDiscard.setText("Discard Changes");
        jButtonDiscard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDiscardActionPerformed(evt);
            }
        });

        jLabel1.setText("ID");

        jButtonSave.setText("Save Changes");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jTextFieldId.setEditable(false);

        jLabel3.setText("Name");

        jToggleButtonEnablePass.setText("Change Password");
        jToggleButtonEnablePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonEnablePassActionPerformed(evt);
            }
        });

        jLabel4.setText("Re-Enter New Password");

        jLabel2.setText("Enter Current Password");

        jLabel5.setText("Enter New Password");

        jLabel6.setText("Phone Number");

        jLabel7.setText("Email");

        jPasswordFieldCurrent.setEditable(false);

        jPasswordFieldNew.setEditable(false);

        jPasswordFieldReEnter.setEditable(false);

        jLabel8.setText("Gender");

        jLabel9.setText("Date of Birth");

        jComboBoxGender.setModel(new javax.swing.DefaultComboBoxModel<>());

        jLabelWarning.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelWarning.setMinimumSize(new java.awt.Dimension(10, 10));
        jLabelWarning.setPreferredSize(new java.awt.Dimension(200, 20));

        jResetButton1.setText("Reset Fields");
        jResetButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jResetButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(172, 172, 172)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(100, 100, 100)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jToggleButtonEnablePass)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPasswordFieldNew, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPasswordFieldReEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPasswordFieldCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(44, 44, 44)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jComboBoxGender, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jTextFieldName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(209, 209, 209)
                                .addComponent(jButtonDiscard)
                                .addGap(24, 24, 24)
                                .addComponent(jButtonSave)
                                .addGap(27, 27, 27)
                                .addComponent(jResetButton1)))
                        .addGap(0, 225, Short.MAX_VALUE))
                    .addComponent(jLabelWarning, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBoxGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jToggleButtonEnablePass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordFieldCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPasswordFieldNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jPasswordFieldReEnter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21)
                .addComponent(jLabelWarning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDiscard)
                    .addComponent(jButtonSave)
                    .addComponent(jResetButton1))
                .addGap(72, 72, 72))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButtonDiscardActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonDiscardActionPerformed
        int confirmation = JOptionPane.showOptionDialog(
                SpManagePersonal.this,
                "Are you sure you want to discard changes?",
                "Discard Changes",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                new String[]{"Confirm", "Cancel"},
                "Confirm"
        );
        
        if (confirmation == JOptionPane.YES_OPTION) {
            dispose();
        } else {
            ((JDialog) SwingUtilities.getRoot((Component) evt.getSource())).dispose();
        }
        
    }//GEN-LAST:event_jButtonDiscardActionPerformed

    private void jButtonSaveActionPerformed(ActionEvent evt) {                                                                      
        String userID = salesperson.getUserID();
        String name = jTextFieldName.getText();
        String gender = String.valueOf(jComboBoxGender.getSelectedItem());
        LocalDate birthDate = HandleAccount.convertDateToLocalDate(jDateChooser.getDate());
        String phone = jTextFieldPhone.getText();
        String email = jTextFieldEmail.getText();
        String oldPassword = String.valueOf(jPasswordFieldCurrent.getPassword());
        String newPassword = String.valueOf(jPasswordFieldNew.getPassword());
        String rePassword = String.valueOf(jPasswordFieldReEnter.getPassword());

        boolean changePass = jToggleButtonEnablePass.isSelected();

        try {
            if (!validateInformation(changePass, name, birthDate, phone, email, oldPassword, newPassword, rePassword)) {
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String dateOfBirth = HandleAccount.localDateToString(birthDate);
        String[] newInfo = {userID, rePassword, name, gender, dateOfBirth, phone, email};

        Salesperson.savePersonal(newInfo, changePass, salesperson);

        // Modify current user data
        salesperson.setName(name);
        if (changePass){
            salesperson.setPassword(HandleAccount.hashString(rePassword));
        }
        salesperson.setPhoneNumber(phone);
        salesperson.setEmail(email);
        setPasswordField(false);

        JOptionPane.showMessageDialog(this, "Profile saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

        currentInstance = null;
        dispose();
    }                                           

    private void jToggleButtonEnablePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonEnablePassActionPerformed
        setPasswordField(jToggleButtonEnablePass.isSelected());
    }//GEN-LAST:event_jToggleButtonEnablePassActionPerformed

    private void jResetButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jResetButton1ActionPerformed
        jTextFieldName.setText(salesperson.getName());
        jComboBoxGender.setSelectedItem(salesperson.getGender().equals(String.valueOf(Gender.MALE)) ? Gender.MALE: Gender.FEMALE);
        jDateChooser.setDate(HandleAccount.convertLocalDateToDate(HandleAccount.stringToLocalDate(salesperson.getDateOfBirth())));
        jTextFieldPhone.setText(salesperson.getPhoneNumber());
        jTextFieldEmail.setText(salesperson.getEmail());
        jToggleButtonEnablePass.setSelected(false);
        setPasswordField(false);
    }//GEN-LAST:event_jResetButton1ActionPerformed


    /**
     * validate the information
     * @param changePass is change password enable?
     * @param name name
     * @param birthDate date of birth
     * @param phone phone
     * @param email email
     * @param oldPassword old password
     * @param newPassword new password
     * @param rePassword re-enter password
     * @return true if all information correct, vice versa
     * @throws Exception exception
     */
    private boolean validateInformation(boolean changePass, String name, LocalDate birthDate, String phone, String email, String oldPassword, String newPassword, String rePassword) throws Exception {
        if (name.isEmpty()) {
            jLabelWarning.setText("Please enter proper name");
            return false;
        } else if (!HandleAccount.validateBOD(birthDate, 18)){
            jLabelWarning.setText("The age of salesperson must be 18 or above.");
            return false;
        }else if (!HandleAccount.validatePhone(phone)) {
            jLabelWarning.setText("Please enter valid Malaysia phone number");
            return false;
        } else if (!HandleAccount.validateEmail(email)) {
            jLabelWarning.setText("Please enter valid email");
            return false;
        }

        // Password Validation
        if (changePass) {
            return validatePassword(oldPassword, newPassword, rePassword);
        }
        return true;
    }

    /**
     * Validate password format, and make sure re-enter password match to new password
     * @param oldPassword old password
     * @param newPassword new password
     * @param rePassword re-enter password
     * @return true if all correct, vice versa
     */
    private boolean validatePassword(String oldPassword, String newPassword, String rePassword) {
        if (!salesperson.getPassword().equals(HandleAccount.hashString(oldPassword))) {
            jLabelWarning.setText("Current Password is incorrect.");
        } else if (!HandleAccount.validateNewPassword(newPassword)) {
            jLabelWarning.setText("The new password must be at least 8 characters, 1 Capital Letter, and 1 symbol.");
        } else if (!HandleAccount.comparePassword(newPassword, rePassword)) {
            jLabelWarning.setText("Re-enter password does not match new password.");
        } else {
            return true;
        }
        return false; // Password validation passed
    }

    /**
     * setEnable of password field
     * @param set true to enable, false to disable
     */
    private void setPasswordField(boolean set){
        jPasswordFieldCurrent.setEditable(set);
        jPasswordFieldNew.setEditable(set);
        jPasswordFieldReEnter.setEditable(set);

        jPasswordFieldCurrent.setText("");
        jPasswordFieldNew.setText("");
        jPasswordFieldReEnter.setText("");
    }
    private void selfInitComponents(){
        jTextFieldId.setText(salesperson.getUserID());

        jComboBoxGender.addItem(Gender.MALE);
        jComboBoxGender.addItem(Gender.FEMALE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDiscard;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JComboBox<Gender> jComboBoxGender;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelWarning;
    private javax.swing.JPasswordField jPasswordFieldCurrent;
    private javax.swing.JPasswordField jPasswordFieldNew;
    private javax.swing.JPasswordField jPasswordFieldReEnter;
    private javax.swing.JButton jResetButton1;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldPhone;
    private javax.swing.JToggleButton jToggleButtonEnablePass;
    // End of variables declaration//GEN-END:variables
}