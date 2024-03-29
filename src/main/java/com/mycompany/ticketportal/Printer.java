/*
 *  @ Daniel Rakovský
 */
package com.mycompany.ticketportal;

import static com.mycompany.ticketportal.Ledger.customerArrayList;
import static com.mycompany.ticketportal.Ledger.customerLastNameIdMap;
import static com.mycompany.ticketportal.Ledger.ticketArrayList;
import static com.mycompany.ticketportal.Ledger.ticketDestinationIdMap;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class Printer {
    
    public static String printTicketInfo(Ticket t){
        String info = null;
        if (!t.isSold){
            System.out.println("\nNobody has bought ticket yet.");
            System.out.println("Price: " + t.price);
            System.out.println("Ticket sold: " + t.isSold + "\n");
            info = "\nDestination:" + t.destination +"\n Price: " +  t.price + "\nTicket sold:" + t.isSold;
        }
        else{
            System.out.println("\nFirst name: " + t.owner.firstName);
            System.out.println("Last name: " + t.owner.lastName);
            System.out.println("Destination: " + t.destination);
            System.out.println("Price: " + t.price);
            System.out.println("Ticket sold: " + t.isSold+ "\n");
            info = "\nDestination:" + t.destination +"\n Price: " +  t.price + "\nTicket sold:" + t.isSold;
        }
        return info;
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
    
    public static void printCustomerInfo(Customer c){
        if(!customerArrayList.contains(c)){
            System.out.println("Method printCustomerInfo.");
            System.out.println("Customer not found.");
        }
        else{
            System.out.println("Method printCustomerInfo.");
            System.out.println("ID of customer: " + c.idCustomer);
            System.out.println("First name: " + c.firstName);
            System.out.println("Last name: " + c.lastName);
        }
    
    }
    
    public static void printTicketArrayList(){
        if(ticketArrayList.size() < 0){
            System.out.println("No tickets in ArrayList");
        }
        else{
            for(int i = 0; i < ticketArrayList.size(); i++){
                Ticket t = ticketArrayList.get(i);
                System.out.println("\nID: " + t.idTicket);
                System.out.println("Origin: " + t.origin);
                System.out.println("Destination: " + t.destination);
                if(t.owner != null){
                    System.out.println("Last name: " + t.owner.lastName);
                }
            }
            
           
        }
    
    }
    
    
}
