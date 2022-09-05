/*
 *  @ Daniel Rakovský
 */
package com.mycompany.ticketportal;

import static com.mycompany.ticketportal.GuiHandler.createChangePasswordWindow;
import static com.mycompany.ticketportal.GuiHandler.createFirstWindow;
import static com.mycompany.ticketportal.GuiHandler.createReturnTicketWindow;
import static com.mycompany.ticketportal.GuiHandler.createSearchTicketWindow;
import static com.mycompany.ticketportal.GuiHandler.createShoppingCartWindow;
import static com.mycompany.ticketportal.TicketPortal.logedInCustomer;
import static com.mycompany.ticketportal.TicketPortal.currentTicket;
import static com.mycompany.ticketportal.TicketPortal.privateLogedInCustomer;
/**
 *
 * @author Daniel
 */
public class CustomerMainMenuWindow extends javax.swing.JFrame {

    /**
     * Creates new form CustomerMainMenu
     */
    public CustomerMainMenuWindow() {
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

        searchTicketButton = new javax.swing.JButton();
        cartButton = new javax.swing.JButton();
        returnTicketButton = new javax.swing.JButton();
        changePasswordButton = new javax.swing.JButton();
        Help = new javax.swing.JButton();
        logOff = new javax.swing.JButton();
        customerMainMenuLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        searchTicketButton.setText("Search Ticket");
        searchTicketButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTicketButtonActionPerformed(evt);
            }
        });

        cartButton.setText("Shoping cart");
        cartButton.setPreferredSize(new java.awt.Dimension(125, 25));
        cartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartButtonActionPerformed(evt);
            }
        });

        returnTicketButton.setText("Return ticket");
        returnTicketButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnTicketButtonActionPerformed(evt);
            }
        });

        changePasswordButton.setText("Change Password");
        changePasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordButtonActionPerformed(evt);
            }
        });

        Help.setText("Help");
        Help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HelpActionPerformed(evt);
            }
        });

        logOff.setText("Log off");
        logOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOffActionPerformed(evt);
            }
        });

        customerMainMenuLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        customerMainMenuLabel.setText("Welcome Daniel Rakovský");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Help, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(logOff, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(returnTicketButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchTicketButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cartButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(changePasswordButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(66, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(customerMainMenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customerMainMenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTicketButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(returnTicketButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changePasswordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logOff)
                    .addComponent(Help, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );

        customerMainMenuLabel.setText("Welcome " + logedInCustomer.firstName + " " + logedInCustomer.lastName);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchTicketButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTicketButtonActionPerformed
        // TODO add your handling code here:
        createSearchTicketWindow();
        this.dispose();
    }//GEN-LAST:event_searchTicketButtonActionPerformed

    private void returnTicketButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnTicketButtonActionPerformed
        // TODO add your handling code here:
        createReturnTicketWindow();
        this.dispose();
    }//GEN-LAST:event_returnTicketButtonActionPerformed

    private void HelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HelpActionPerformed

    private void logOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOffActionPerformed
        // TODO add your handling code here:
        createFirstWindow();
        privateLogedInCustomer = null;
        currentTicket = null;
        logedInCustomer = null;
        this.dispose();
    }//GEN-LAST:event_logOffActionPerformed

    private void cartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartButtonActionPerformed
        // TODO add your handling code here:
        createShoppingCartWindow();
        this.dispose();
    }//GEN-LAST:event_cartButtonActionPerformed

    private void changePasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordButtonActionPerformed
        // TODO add your handling code here:
        createChangePasswordWindow();
        this.dispose();
    }//GEN-LAST:event_changePasswordButtonActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerMainMenuWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerMainMenuWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerMainMenuWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerMainMenuWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerMainMenuWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Help;
    private javax.swing.JButton cartButton;
    private javax.swing.JButton changePasswordButton;
    private javax.swing.JLabel customerMainMenuLabel;
    private javax.swing.JButton logOff;
    private javax.swing.JButton returnTicketButton;
    private javax.swing.JButton searchTicketButton;
    // End of variables declaration//GEN-END:variables
}
