/*
 *  @ Daniel Rakovský
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
