/*
 *  @ Danile Rakovský
$RequestHeader set AuditDate expr=%{TIME_YEAR}-%{TIME_MON}-%{TIME_DAY}
$RequestHeader set AuditDateTime expr=%{TIME}
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ticketportal;

import static com.mycompany.ticketportal.Ledger.customerArrayList;
import static com.mycompany.ticketportal.Ledger.customerLastNameIdMap;
import static com.mycompany.ticketportal.Ledger.ticketArrayList;
import static com.mycompany.ticketportal.Ledger.ticketDestinationIdMap;
import static com.mycompany.ticketportal.TicketPortal.printCustomerInfo;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class Printer {
    
    public static void printTicketInfo(Ticket t){
        if (!t.isSold){
            System.out.println("\nNobody has bought ticket yet.");
            System.out.println("Price: " + t.price);
            System.out.println("Ticket sold: " + t.isSold + "\n");
        }
        else{
            System.out.println("\nFirst name: " + t.owner.firstName);
            System.out.println("Last name: " + t.owner.lastName);
            System.out.println("Destination: " + t.destination);
            System.out.println("Price: " + t.price);
            System.out.println("Ticket sold: " + t.isSold+ "\n");
        }
    }
    
    public static Ticket searchTicketPrint(){
        String destination;
        Ticket t = null;
        
        System.out.println("\nMethod searching Ticket by destination.");
        System.out.println("Enter destination: ");
        Scanner scanner = new Scanner(System.in);
        destination = scanner.nextLine();
        
        if(ticketDestinationIdMap.containsKey(destination)){
            int idOfTicket = (ticketDestinationIdMap.get(destination));
            t = ticketArrayList.get(idOfTicket);
            printTicketInfo(t);
        }
        else{
            System.out.println("\nDestination not found.");
        }
        
        return t;
    }
    
    public static Customer searchCustomerPrint(){
        String lastName;
        Customer c = null;
        
        System.out.println("Method searching Customer ID by last name.");
        System.out.println("Enter last name: ");
        Scanner scanner = new Scanner(System.in);
        lastName = scanner.nextLine();
        
        if(customerLastNameIdMap.containsKey(lastName)){
            int idOfCustomer = customerLastNameIdMap.get(lastName);
            c = customerArrayList.get(idOfCustomer);
        
            printCustomerInfo(c);
        }
        else{
            System.out.println("Last name not found.");
        }
 
        return c;
    }
    
}
