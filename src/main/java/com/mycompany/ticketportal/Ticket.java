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
        Ledger.ticketDestinationIdMap.put(destination, idTicket);
    }
}
