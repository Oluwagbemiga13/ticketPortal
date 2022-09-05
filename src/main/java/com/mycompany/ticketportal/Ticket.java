/*
 *  @ Daniel Rakovský
 */
package com.mycompany.ticketportal;


/**
 *
 * @author Daniel
 * O: Má cenu popisovat takhle malé třídy,  když jsou takhle duležité ??? A:ne
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
    
    public Ticket(String origin, String destination, int price){
        this.destination = destination;
        this.price = price;
        this.origin = origin;

        idTicket = counterOfTickets + 1;
        counterOfTickets++;
        
        Ledger.ticketArrayList.add(idTicket,this);
        Ledger.ticketDestinationIdMap.put(destination, idTicket);
        Ledger.ticketOriginMap.put(this, origin);
        Ledger.ticketDestinationMap.put(this, destination);
    }  
}
