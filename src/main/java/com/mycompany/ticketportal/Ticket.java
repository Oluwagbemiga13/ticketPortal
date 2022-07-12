/*
 *  @ Danile Rakovský
$RequestHeader set AuditDate expr=%{TIME_YEAR}-%{TIME_MON}-%{TIME_DAY}
$RequestHeader set AuditDateTime expr=%{TIME}
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ticketportal;


/**
 *
 * @author Daniel
 */
public class Ticket {
    String destination;
    int price;
    boolean isSold;
    Customer owner;
    int idTicket;
    public static int counterOfTickets = -1;
    
    public Ticket(String destination,int price){
        this.destination = destination;
        this.price = price;
        isSold = false;
        idTicket = counterOfTickets + 1;
        counterOfTickets++;
        Ledger.ticketArrayList.add(idTicket,this);
    }
    
    public void sell(Customer c){
        owner = c; 
        isSold = true;
        Ledger.customerTicktetMap.put(c.idCustomer, idTicket);
        System.out.println("Ticket ID: " + idTicket + " was sold to " + c.firstName + " " + c.lastName);
        System.out.println("\n");
    }
    
    public void returnTicket(){
        owner = null;
        isSold = false;
    }
    
    public void printTicketInfo(){
        if (!isSold){
            System.out.println("Nobody has bought ticket yet.");
            System.out.println("Price: " + price);
            System.out.println("Ticket sold: " + isSold + "\n");
        }
        else{
            System.out.println("First name: " + owner.firstName);
            System.out.println("Last name: " + owner.lastName);
            System.out.println("Destination: " + destination);
            System.out.println("Price: " + price);
            System.out.println("Ticket sold: " + isSold+ "\n");
        }
    }
}