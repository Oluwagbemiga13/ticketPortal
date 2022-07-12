/*
 *  @ Danile Rakovský
$RequestHeader set AuditDate expr=%{TIME_YEAR}-%{TIME_MON}-%{TIME_DAY}
$RequestHeader set AuditDateTime expr=%{TIME}
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ticketportal;

import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class Customer {
    int idCustomer;
    String firstName;
    String lastName;
    public static int counterOfCustomers = -1;

    public Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        idCustomer = counterOfCustomers + 1;
        counterOfCustomers++;
        Ledger.customerArrayList.add(idCustomer,this);
    }
   
}
