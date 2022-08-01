/*
 *  @ Danile Rakovský
$RequestHeader set AuditDate expr=%{TIME_YEAR}-%{TIME_MON}-%{TIME_DAY}
$RequestHeader set AuditDateTime expr=%{TIME}
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ticketportal;

import static com.mycompany.ticketportal.GuiHandler.createAdminLogInWindow;
import static com.mycompany.ticketportal.GuiHandler.createFirstWindow;
import static com.mycompany.ticketportal.Ledger.loginPasswordMap;
import static com.mycompany.ticketportal.Ledger.privateCustomerArrayList;
import static com.mycompany.ticketportal.TicketPortal.logIn;



/**
 *
 * @author Daniel
 */
public class LogInWindow extends javax.swing.JFrame {

    /**
     * Creates new form LogInWindow
     */
    
    String invalidMessage = "Invalid input";
    
    // Takes login and checks if it exists
    public boolean isValidLogin(){
        
        boolean isValid = true;
        String login = loginLogin.getText();
        if(!loginPasswordMap.containsKey(login)){
            isValid = false;
            invalidMessageLabel.setVisible(true);
        } 
    return isValid;
    }
    
    // Takes login and password and returns true if mathces.
    public boolean isValidPassword(){
        boolean isValid = true;

        String login = loginLogin.getText();
        char[] passwordArr = passwordLogin.getPassword();
        
        String password = String.valueOf(passwordArr);
        
        if (!loginPasswordMap.get(login).equals(password)){
            isValid = false;
        }
    return isValid;
    } 
    
    public LogInWindow() {
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

        jLabel2 = new javax.swing.JLabel();
        loginLogin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        passwordLogin = new javax.swing.JPasswordField();
        okButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        danielButton = new javax.swing.JButton();
        invalidMessageLabel = new javax.swing.JLabel();
        adminLogInButton = new javax.swing.JButton();
        karelButton = new javax.swing.JButton();
        headerLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel2.setText("Login");

        loginLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginLoginActionPerformed(evt);
            }
        });

        jLabel3.setText("Password");

        passwordLogin.setMinimumSize(new java.awt.Dimension(112, 22));
        passwordLogin.setName(""); // NOI18N
        passwordLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordLoginActionPerformed(evt);
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

        danielButton.setText("Daniel");
        danielButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                danielButtonActionPerformed(evt);
            }
        });

        invalidMessageLabel.setForeground(new java.awt.Color(255, 51, 51));
        invalidMessageLabel.setText("Invalid message");

        adminLogInButton.setText("Admin Log in");
        adminLogInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminLogInButtonActionPerformed(evt);
            }
        });

        karelButton.setText("Karel");
        karelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                karelButtonActionPerformed(evt);
            }
        });

        headerLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        headerLabel.setText("Log in");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(okButton)
                        .addGap(18, 18, 18)
                        .addComponent(backButton)
                        .addGap(44, 44, 44))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(invalidMessageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(passwordLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(loginLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(headerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adminLogInButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(danielButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(karelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(invalidMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(danielButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(karelButton))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(backButton)
                    .addComponent(adminLogInButton))
                .addGap(25, 25, 25))
        );

        invalidMessageLabel.setVisible(false);
        headerLabel.setFont(headerLabel.getFont().deriveFont(25f));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginLoginActionPerformed

    //Q: Mám na to vytvořit metodu, i když to použiji jen když se klikne na Button ???
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
        String login = loginLogin.getText();
        char[] passwordArr = passwordLogin.getPassword();
        String password = String.valueOf(passwordArr);
        boolean isValid = true;
        System.out.println("okButtonActionPerformed()  login = " + login);

        if(!isValidLogin()){
            isValid = false;
            invalidMessageLabel.setText("Invalid login!");
            loginLogin.setText("");
        }
        if (!isValidPassword()){
            invalidMessageLabel.setText("Invalid password");
            passwordLogin.setText("123456");
            invalidMessageLabel.setVisible(true);
            isValid = false;
            passwordArr = null;
        }
        if(isValid){
            passwordArr = passwordLogin.getPassword();
            password = String.valueOf(passwordArr);
            System.out.println("okButtonActionPerformed()  password = " + password);
            System.out.println("String.valueOf(passwordArr) = " + String.valueOf(passwordArr));
            logIn(login, password);
            this.dispose();
        }
    }//GEN-LAST:event_okButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        createFirstWindow();
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    // Fill the form with test variables
    private void danielButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_danielButtonActionPerformed
        // TODO add your handling code here:
        passwordLogin.setText("Danda1");
        loginLogin.setText("Danda1");
    }//GEN-LAST:event_danielButtonActionPerformed

    private void passwordLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordLoginActionPerformed

    private void adminLogInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminLogInButtonActionPerformed
        // TODO add your handling code here:
        createAdminLogInWindow();
        this.dispose();
    }//GEN-LAST:event_adminLogInButtonActionPerformed

    private void karelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_karelButtonActionPerformed
        // TODO add your handling code here:
        passwordLogin.setText("Karel1");
        loginLogin.setText("Karel1");
    }//GEN-LAST:event_karelButtonActionPerformed

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
            java.util.logging.Logger.getLogger(LogInWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogInWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogInWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogInWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogInWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminLogInButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton danielButton;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JLabel invalidMessageLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton karelButton;
    private javax.swing.JTextField loginLogin;
    private javax.swing.JButton okButton;
    private javax.swing.JPasswordField passwordLogin;
    // End of variables declaration//GEN-END:variables
}
