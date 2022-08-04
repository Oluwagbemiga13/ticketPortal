/*
 *  @ Danile Rakovský
$RequestHeader set AuditDate expr=%{TIME_YEAR}-%{TIME_MON}-%{TIME_DAY}
$RequestHeader set AuditDateTime expr=%{TIME}
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ticketportal;

import static com.mycompany.ticketportal.Ledger.customerTicktetMap;
import static com.mycompany.ticketportal.Ledger.soldTicketArrayList;
import static com.mycompany.ticketportal.Ledger.ticketArrayList;
import static com.mycompany.ticketportal.Printer.printTicketInfo;
import static com.mycompany.ticketportal.TicketPortal.logedInCustomer;
import static com.mycompany.ticketportal.TicketPortal.searchTicket;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

/**
 *
 * @author Daniel
 */
public class Vendor {
    
    int idVendor = 1;
    String nameVendor = "Vendor " + Integer.toString(idVendor);
    
    public Vendor(){
        idVendor++;
    }
    
    public static void sell(Customer c, Ticket t){
        if(!t.isSold){
            t.owner = c; 
            t.isSold = true;
            Ledger.customerTicktetMap.put(c.idCustomer, t.idTicket);
            c.customerCart.add(t);
        
            System.out.println("\nMethod sellTicket");
            System.out.println("Ticket ID: " + t.idTicket + " was sold to " + c.firstName + " " + c.lastName);
        }
    }
    
    // Method that searches KEY by it´s VALUE
    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
    for (Entry<T, E> entry : map.entrySet()) {
        if (Objects.equals(value, entry.getValue())) {
            return entry.getKey();
        }
    }
    return null;
    }
    
    public static void pay(){
        Customer c = logedInCustomer;
        
        for(Ticket t : c.customerCart){
            soldTicketArrayList.add(t);
            int position  = t.idTicket;
            ticketArrayList.set(position, null);
            t = null;
        }
        c.customerCart.clear();
        System.out.println("ticketArrayList: " + ticketArrayList.toString());
        System.out.println("soldTicketArrayList: " + soldTicketArrayList.toString());
        System.out.println("customerCart: " + c.customerCart.toString());
    }
    
    public static void returnTicket(int idOfTicket){
        
        Ticket t;
        Customer c = logedInCustomer;
        ArrayList<Ticket> temp = new ArrayList<>();
        boolean wasFound = false;
        
        for(int i = 0; i<c.customerCart.size();i++){
            if(c.customerCart.get(i).idTicket == idOfTicket){
                t = c.customerCart.get(i);
                ticketArrayList.set(idOfTicket, t);
                wasFound = true;
                t.isSold = false;
            }
            else{
                temp.add(c.customerCart.get(i));
            }
        }
        if(wasFound){
            c.customerCart.clear();
            for(int i = 0; i < temp.size(); i++){
                c.customerCart.add(temp.get(i));
            }
        }

        System.out.println("ticketArrayList: " + ticketArrayList.toString());
        System.out.println("soldTicketArrayList: " + soldTicketArrayList.toString());
        System.out.println("customerCart: " + c.customerCart.toString());
    }
    
    
}
