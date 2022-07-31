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
 * Q: Má cenu popisovat takhle malé třídy,  když jsou takhle duležité ???
 * Object Ticket represents...
 */
public class Ticket {
    String destination;
    String origin;
    int price;
    boolean isSold;
    Customer owner;
    int idTicket;
    public static int counterOfTickets = -1;
    
    public Ticket(String destination,int price, String origin){
        this.destination = destination;
        this.price = price;
        this.origin = origin;
        isSold = false;
        idTicket = counterOfTickets + 1;
        counterOfTickets++;
        
        Ledger.ticketArrayList.add(idTicket,this);
        Ledger.ticketDestinationIdMap.put(destination, idTicket);
    }
}
