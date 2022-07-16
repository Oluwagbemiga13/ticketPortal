/*
 *  @ Danile Rakovský
$RequestHeader set AuditDate expr=%{TIME_YEAR}-%{TIME_MON}-%{TIME_DAY}
$RequestHeader set AuditDateTime expr=%{TIME}
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ticketportal;

import static com.mycompany.ticketportal.Ledger.customerTicktetMap;
import static com.mycompany.ticketportal.Printer.printTicketInfo;
import static com.mycompany.ticketportal.TicketPortal.searchTicket;
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
    
    public void sell(Customer c, Ticket t){
        t.owner = c; 
        t.isSold = true;
        Ledger.customerTicktetMap.put(c.idCustomer, t.idTicket);
     
        System.out.println("\nTicket ID: " + t.idTicket + " was sold to " + c.firstName + " " + c.lastName);
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
    
    
    public static void returnTicket(){
        Ticket t = searchTicket();
        
        int ticketKey = getKeyByValue(customerTicktetMap,t.idTicket);
        customerTicktetMap.remove(ticketKey);
        
        System.out.println("\nTicket ID: " + t.idTicket + "was returned by " + t.owner.firstName + t.owner.lastName);
        
        t.owner = null;
        t.isSold = false;
        // TEST print
        printTicketInfo(t);
    }
    
}
