/*
 *  @ Daniel Rakovský
 */
package com.mycompany.ticketportal;

import static com.mycompany.ticketportal.GuiHandler.createFirstWindow;
import static com.mycompany.ticketportal.Ledger.customerArrayList;
import static com.mycompany.ticketportal.Ledger.loginPositionMap;
import static com.mycompany.ticketportal.Ledger.privateCustomerArrayList;
import static com.mycompany.ticketportal.TicketPortal.createAcc;
//import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 *
 * @author Daniel
 */
public class CreateAccountWindow extends javax.swing.JFrame {
    
    //Pattern numPattern = Pattern.compile("([0-9])");
    
    public boolean isExistingLogin(){
        boolean isExisting = false;
        String login = loginField.getText();
        
        for(int i = 0; i < customerArrayList.size(); i++){
            String existingLogin = (privateCustomerArrayList.get(i)).login;
            if(existingLogin.equals(login)){
                isExisting = true;
                loginValidLabel.setText("Login exists");
                
            }
        }
        return isExisting;
    }
    
    public void colectDataCreateAccountWindow(){
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String login = loginField.getText();
        String password = passwordField.getText();
        int positionInArray = customerArrayList.size();

        createAcc(firstName, lastName, login, password);
        Printer.printCustomerInfo(Ledger.customerArrayList.get(customerArrayList.size()-1));
        System.out.println("Counter: " + (customerArrayList.size()-1));
        
        createFirstWindow();
        this.dispose();
    }
    
    public boolean validFirstName(){
        boolean isValid = true;
        String firstName = firstNameField.getText();

        for(char c : firstName.toCharArray()){
            if(Character.isDigit(c)){
                isValid = false;
                firstNameValidLabel.setText("No numbers allowed!");
            }
        }
        if(firstName.length()==0){
            isValid = false;
            firstNameValidLabel.setText("Enter first name");
        }

        return isValid;
    }
    
    public boolean validLastName(){
        boolean isValid = true;
        String lastName = lastNameField.getText();
        
        for(char c : lastName.toCharArray()){
            if(Character.isDigit(c)){
                isValid = false;
                lastNameValidLabel.setText("No numbers allowed!");
            }
        }
        
        if(lastName.length()==0){
            isValid = false;
            lastNameValidLabel.setText("Enter last name");
        }

        return isValid;
    }
    
    public boolean validLogin(){
        boolean isValid = true;
        String login = loginField.getText();
        
        if(login.length()<=5){
            isValid = false;
            loginValidLabel.setText("Must contain at least 5 characters");
        }
        if(isExistingLogin()){
            isValid = false;
        }

        return isValid;
    }
    
    public boolean validPassword(){
        boolean isValid = false;
        String password = passwordField.getText();
        char[] passwordArr = password.toCharArray();
        
        boolean intFlag = true;
        if(password.length() < 6){
            intFlag = false;
            passwordValidLabel.setText("Must contain at least 6 characters");
        }

        boolean numFlag = false;
        for (char c : passwordArr){
            if(Character.isDigit(c)){
                numFlag = true;
            }
        }
        if(!numFlag){
        passwordValidLabel.setText("Must contain at least one digit");
        }
        
        boolean charflag = false;
        for (char c : passwordArr){
            if(Character.isLetter(c)){
                charflag = true;
            }
        }
        if(!charflag){
        passwordValidLabel.setText("Must contain at least one character");
        }
        
        if(intFlag && numFlag && charflag){
            isValid = true;
        }
        
        return isValid;
    }
    

    /**
     * Creates new form CreateAccountWindow
     */
    
    int createdCustomerCounter = 0;
    public CreateAccountWindow() {
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

        jLabel1 = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lastNameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        loginField = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        passwordField = new javax.swing.JTextField();
        testPrintButton = new javax.swing.JButton();
        firstNameValidLabel = new javax.swing.JLabel();
        lastNameValidLabel = new javax.swing.JLabel();
        loginValidLabel = new javax.swing.JLabel();
        passwordValidLabel = new javax.swing.JLabel();
        testFillButton = new javax.swing.JButton();
        karelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("First name");

        firstNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Last name");

        lastNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("Login");

        loginField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginFieldActionPerformed(evt);
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

        jLabel4.setText("Password");

        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        testPrintButton.setText("Print in terminal");
        testPrintButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testPrintButtonActionPerformed(evt);
            }
        });

        firstNameValidLabel.setForeground(new java.awt.Color(255, 51, 51));
        firstNameValidLabel.setText("Invalid first name");

        lastNameValidLabel.setForeground(new java.awt.Color(255, 51, 51));
        lastNameValidLabel.setText("Invalid last name");

        loginValidLabel.setForeground(new java.awt.Color(255, 51, 51));
        loginValidLabel.setText("Invalid login");

        passwordValidLabel.setForeground(new java.awt.Color(255, 0, 0));
        passwordValidLabel.setText("Invalid password");

        testFillButton.setText("Daniel");
        testFillButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testFillButtonActionPerformed(evt);
            }
        });

        karelButton.setText("Karel");
        karelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                karelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(firstNameValidLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                    .addComponent(lastNameValidLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(passwordValidLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(loginField, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(loginValidLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(karelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(testFillButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(testPrintButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(okButton)
                        .addGap(18, 18, 18)
                        .addComponent(backButton)))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstNameValidLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(karelButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastNameValidLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(loginField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(loginValidLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(passwordValidLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(okButton)
                            .addComponent(backButton))
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(testFillButton)
                        .addGap(18, 18, 18)
                        .addComponent(testPrintButton)
                        .addContainerGap())))
        );

        firstNameValidLabel.setVisible(false);
        lastNameValidLabel.setVisible(false);
        loginValidLabel.setVisible(false);
        passwordValidLabel.setVisible(false);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void firstNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameFieldActionPerformed

    private void lastNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameFieldActionPerformed

    private void loginFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginFieldActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
        //colectDataCreateAccountWindow();
        
        
        if(validFirstName() && validLastName() && validLogin() && validPassword()){
            this.colectDataCreateAccountWindow();
        }
        else{
            if(!validFirstName()){
                firstNameValidLabel.setVisible(true);
            }
        
            if(!validLastName()){
                lastNameValidLabel.setVisible(true);
            }
        
            if(!validLogin()){
                loginValidLabel.setVisible(true);
            }
            if(!validPassword()){
                passwordValidLabel.setVisible(true);
            }
        } 
    }//GEN-LAST:event_okButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        createFirstWindow();
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void testPrintButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testPrintButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("Customer array:");
        for(int i = 0; i < customerArrayList.size(); i++){
        System.out.println(Ledger.customerArrayList.get(i).firstName);
        System.out.println(Ledger.customerArrayList.get(i).lastName);
        System.out.println(Ledger.customerArrayList.get(i).idCustomer);
        }
        
        System.out.println("Private customer array:");
        for(int i = 0; i < privateCustomerArrayList.size(); i++){
        System.out.println(Ledger.privateCustomerArrayList.get(i).login);
        System.out.println(Ledger.privateCustomerArrayList.get(i).privateFirstName);
        System.out.println(Ledger.privateCustomerArrayList.get(i).privateLastName);
        System.out.println(Ledger.privateCustomerArrayList.get(i).privatePassword);
        }
        
        System.out.println("Login position map:");
        for(int i = 0; i < loginPositionMap.size(); i++){
        System.out.print(Ledger.privateCustomerArrayList.get(i).login + " ");
        System.out.println(Ledger.loginPositionMap.get(Ledger.privateCustomerArrayList.get(i).login));
        }

    }//GEN-LAST:event_testPrintButtonActionPerformed

    private void testFillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testFillButtonActionPerformed
        // TODO add your handling code here:
        firstNameField.setText("Daniel");
        lastNameField.setText("Rakovský");
        loginField.setText("Danda1");
        passwordField.setText("Danda1");
    }//GEN-LAST:event_testFillButtonActionPerformed

    private void karelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_karelButtonActionPerformed
        // TODO add your handling code here:
        firstNameField.setText("Karel");
        lastNameField.setText("Hrnčíř");
        loginField.setText("Karel1");
        passwordField.setText("Karel1"); 
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
            java.util.logging.Logger.getLogger(CreateAccountWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateAccountWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateAccountWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateAccountWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateAccountWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameValidLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton karelButton;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameValidLabel;
    private javax.swing.JTextField loginField;
    private javax.swing.JLabel loginValidLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField passwordField;
    private javax.swing.JLabel passwordValidLabel;
    private javax.swing.JButton testFillButton;
    private javax.swing.JButton testPrintButton;
    // End of variables declaration//GEN-END:variables
}
