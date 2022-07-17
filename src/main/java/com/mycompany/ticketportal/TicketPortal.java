/*
 *  @ Danile Rakovský
$RequestHeader set AuditDate expr=%{TIME_YEAR}-%{TIME_MON}-%{TIME_DAY}
$RequestHeader set AuditDateTime expr=%{TIME}
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ticketportal;

import static com.mycompany.ticketportal.Ledger.customerArrayList;
import static com.mycompany.ticketportal.Ledger.customerLastNameIdMap;
import static com.mycompany.ticketportal.Ledger.customerTicktetMap;
import static com.mycompany.ticketportal.Ledger.ticketArrayList;
import static com.mycompany.ticketportal.Ledger.ticketDestinationIdMap;
import static com.mycompany.ticketportal.Printer.printTicketInfo;
import static com.mycompany.ticketportal.Printer.searchCustomerPrint;
import static com.mycompany.ticketportal.Printer.searchTicketPrint;
import static com.mycompany.ticketportal.Vendor.returnTicket;
import java.awt.BorderLayout;
import java.util.Scanner;
import javax.swing.JFrame;


/**
 *
 * @author Daniel
 */
public class TicketPortal {
    
    // Method creating customer from user input
    public static Customer createCustomer(){
        
        System.out.println("\nMethod createCustomer() ");
                
        System.out.println("Enter first name: ");
        Scanner scanner = new Scanner(System.in);
        String firstNameCreate = scanner.nextLine();
        
        System.out.println("Eneter last name: ");
        String lastNameCreate = scanner.nextLine();
  

        return new Customer(firstNameCreate, lastNameCreate);
    }
    
    public static Ticket createTicket(){
        
        System.out.println("\nMethod createTicket()");
        System.out.println("Enter destination: ");
        Scanner scanner = new Scanner(System.in);
        String destinationCreate = scanner.nextLine();
        
        System.out.println("Enter price: ");
        
        // Handling worng input
        while(!scanner.hasNextInt()){
            System.out.println("Not integer, try again: ");
            scanner.nextLine();
        }
        int priceCreate = scanner.nextInt();
        
        System.out.println("\n");

        return new Ticket( destinationCreate,priceCreate);
    }
    
    public static Customer searchCustomer(){
        String lastName;
        Customer c = null;
        
        System.out.println("\nMethod searching Customer ID by last name.");
        System.out.println("Enter last name: ");
        Scanner scanner = new Scanner(System.in);
        lastName = scanner.nextLine();
        
        if(customerLastNameIdMap.containsKey(lastName)){
            int idOfCustomer = customerLastNameIdMap.get(lastName);
            c = customerArrayList.get(idOfCustomer);

        }
        else{
            System.out.println("Last name not found.");
        }
 
        return c;
    }
    
    public static Ticket searchTicket(){
        String destination;
        Ticket t = null;
        
        System.out.println("\nMethod searching Ticket by destination.");
        System.out.println("Enter destination: ");
        Scanner scanner = new Scanner(System.in);
        destination = scanner.nextLine();
        
        if(ticketDestinationIdMap.containsKey(destination)){
            int idOfTicket = (ticketDestinationIdMap.get(destination));
            t = ticketArrayList.get(idOfTicket);
        }
        else{
            System.out.println("\nDestination not found.");
        }
        
        return t;
    }
    

public static void main(String [] args){
    System.out.println("Hello");
    //Scanner scanner = new Scanner(System.in);

    FirstWindow firstWindow = new FirstWindow();
    firstWindow.setVisible(true);
   
    
    Ledger ledger = new Ledger();
    
    Vendor vendor = new Vendor();
     
    System.out.println(customerTicktetMap.values());
    
    createCustomer();
    createTicket();

    printTicketInfo(ticketArrayList.get(0));
    
    //TEST SELL
    vendor.sell(customerArrayList.get(0),ticketArrayList.get(0));
    
    printTicketInfo(ticketArrayList.get(0));
    
    //System.out.println(searchCustomer().firstName);
    searchTicketPrint();
    
    searchCustomerPrint();
    
    returnTicket();

    }
}
