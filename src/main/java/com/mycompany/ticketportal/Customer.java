/*
 *  @ Danile Rakovský
$RequestHeader set AuditDate expr=%{TIME_YEAR}-%{TIME_MON}-%{TIME_DAY}
$RequestHeader set AuditDateTime expr=%{TIME}
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ticketportal;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Daniel
 * Object Customer is used when printing out names in GUI
 * 
 */
public class Customer {
    int idCustomer;
    public String firstName;
    public String lastName;
    public static int counterOfCustomers;
    public String password;
    public ArrayList<Ticket> customerCart;

    public Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        idCustomer = counterOfCustomers;
        counterOfCustomers++;
        Ledger.customerArrayList.add(idCustomer,this);
        Ledger.customerLastNameIdMap.put(lastName, idCustomer);
        customerCart = new ArrayList<>();
    }
    
    
   
}
