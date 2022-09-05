/*
 *  @ Daniel Rakovský
 */
package com.mycompany.ticketportal;

import static com.mycompany.ticketportal.GuiHandler.createAdminChangePasswordWindow;
import static com.mycompany.ticketportal.GuiHandler.createAdminMainMenu;
import static com.mycompany.ticketportal.Ledger.administratorLoginPasswordMap;
import static com.mycompany.ticketportal.Ledger.loginPasswordMap;
import static com.mycompany.ticketportal.TicketPortal.logedInAdministrator;
import static com.mycompany.ticketportal.TicketPortal.privateLogedInCustomer;
import java.util.Arrays;

/**
 *
 * @author Daniel
 */
public class AdminChangePasswordWindow extends javax.swing.JFrame {

    /**
     * Creates new form AdminChangePasswordWindow
     */
    char[] oldPasswordArr = null;
    char[] newPasswordArr1 = null;
    char[] newPasswordArr2 = null;
    //String testPasswordHash = loginPasswordMap.get(privateLogedInCustomer.login);
    String testPasswordForm = null;
    
    public boolean corectOldPassword(){
        boolean corect = true;
        oldPasswordArr = oldPassword.getPassword();
        //String password = String.valueOf(oldPasswordArr);
        
        if (Arrays.equals(administratorLoginPasswordMap.get(logedInAdministrator.login), oldPasswordArr)){
        } else {
            corect = false;
            oldPasswordValidLabel.setVisible(true);
        }
        return corect;
    }
    
    public boolean newPasswordsMateches(){
        boolean matches = true;
        
        newPasswordArr1 = newPassword1.getPassword();
        String newPassword1 = String.valueOf(newPasswordArr1);
        
        newPasswordArr2 = newPassword2.getPassword();
        String newPassword2 = String.valueOf(newPasswordArr2);
        
        if(!newPassword1.equals(newPassword2)){
            matches = false;
            newPassword1ValidLabel.setVisible(true);
            newPassword2ValidLabel.setVisible(true);
        }
        return matches;
    }

    public AdminChangePasswordWindow() {
        initComponents();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        oldPassword = new javax.swing.JPasswordField();
        newPassword1 = new javax.swing.JPasswordField();
        newPassword2 = new javax.swing.JPasswordField();
        newPassword1ValidLabel = new javax.swing.JLabel();
        testButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        newPasswordLabel = new javax.swing.JLabel();
        oldPasswordLabel = new javax.swing.JLabel();
        oldPasswordValidLabel = new javax.swing.JLabel();
        newPasswordAgainLabel = new javax.swing.JLabel();
        newPassword2ValidLabel = new javax.swing.JLabel();
        passwordChangedLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        newPassword2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPassword2ActionPerformed(evt);
            }
        });

        newPassword1ValidLabel.setForeground(new java.awt.Color(255, 0, 0));
        newPassword1ValidLabel.setText("Does not match");

        testButton.setText("Test");
        testButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testButtonActionPerformed(evt);
            }
        });

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        newPasswordLabel.setText("New password");

        oldPasswordLabel.setText("Old passoword");

        oldPasswordValidLabel.setForeground(new java.awt.Color(255, 0, 0));
        oldPasswordValidLabel.setText("Wrong password");

        newPasswordAgainLabel.setText("New password");

        newPassword2ValidLabel.setForeground(new java.awt.Color(255, 0, 0));
        newPassword2ValidLabel.setText("Does not match");

        passwordChangedLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        passwordChangedLabel.setForeground(new java.awt.Color(0, 153, 51));
        passwordChangedLabel.setText("Password was changed");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(newPasswordAgainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(newPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(newPassword2ValidLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(newPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(oldPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(oldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(newPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(newPassword1ValidLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(oldPasswordValidLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(okButton)
                                .addGap(43, 43, 43)
                                .addComponent(backButton)
                                .addGap(115, 115, 115))
                            .addComponent(testButton, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(passwordChangedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(passwordChangedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oldPasswordValidLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oldPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newPassword1ValidLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newPasswordAgainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newPassword2ValidLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(backButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(testButton)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        newPassword1ValidLabel.setVisible(false);
        oldPasswordValidLabel.setVisible(false);
        newPassword2ValidLabel.setVisible(false);
        passwordChangedLabel.setVisible(false);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void testButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("Password from form " + Arrays.toString(oldPasswordArr));
        //System.out.println("Password form HashMap" + testPasswordHash);

        testPasswordForm = Arrays.toString(newPasswordArr1);
        System.out.println("Password form form 22" + testPasswordForm);
    }//GEN-LAST:event_testButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
        String login = logedInAdministrator.login;

        if(corectOldPassword() && newPasswordsMateches()){
            //String newPassword = String.valueOf(newPasswordArr1);
            administratorLoginPasswordMap.put(login, newPasswordArr1);
            passwordChangedLabel.setVisible(true);
        }
        else{
            System.out.println("Password was not changed.");
            passwordChangedLabel.setVisible(false);
        }

    }//GEN-LAST:event_okButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        createAdminMainMenu();
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void newPassword2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPassword2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newPassword2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminChangePasswordWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminChangePasswordWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminChangePasswordWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminChangePasswordWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminChangePasswordWindow().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JPasswordField newPassword1;
    private javax.swing.JLabel newPassword1ValidLabel;
    private javax.swing.JPasswordField newPassword2;
    private javax.swing.JLabel newPassword2ValidLabel;
    private javax.swing.JLabel newPasswordAgainLabel;
    private javax.swing.JLabel newPasswordLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JPasswordField oldPassword;
    private javax.swing.JLabel oldPasswordLabel;
    private javax.swing.JLabel oldPasswordValidLabel;
    private javax.swing.JLabel passwordChangedLabel;
    private javax.swing.JButton testButton;
    // End of variables declaration//GEN-END:variables
}
