/*
 *  @ Danile Rakovský
$RequestHeader set AuditDate expr=%{TIME_YEAR}-%{TIME_MON}-%{TIME_DAY}
$RequestHeader set AuditDateTime expr=%{TIME}
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ticketportal;

import static com.mycompany.ticketportal.Ledger.customerArrayList;
import static com.mycompany.ticketportal.Ledger.customerTicktetMap;
import static com.mycompany.ticketportal.Ledger.ticketArrayList;
import java.util.Scanner;


/**
 *
 * @author Daniel
 */
public class TicketPortal {
    
    // Method creating customer from user input
    public static Customer createCustomer(){
        
        System.out.println("Eneter first name: ");
        Scanner scanner = new Scanner(System.in);
        String firstNameCreate = scanner.nextLine();
        
        System.out.println("Eneter last name: ");
        String lastNameCreate = scanner.nextLine();
        
        System.out.println("\n");

        return new Customer(firstNameCreate, lastNameCreate);
    }
    
    public static Ticket createTicket(){
        
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
    
public static void main(String [] args){
    System.out.println("Hello");
    //Scanner scanner = new Scanner(System.in);
    
    Ledger ledger = new Ledger();
     
    System.out.println(customerTicktetMap.values());
    
    createCustomer();
    createTicket();

    ticketArrayList.get(0).printTicketInfo();
    ticketArrayList.get(0).sell(customerArrayList.get(0));
    
    ticketArrayList.get(0).printTicketInfo();

    }
}
