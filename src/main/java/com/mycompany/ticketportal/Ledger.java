/*
 *  @ Danile Rakovský
$RequestHeader set AuditDate expr=%{TIME_YEAR}-%{TIME_MON}-%{TIME_DAY}
$RequestHeader set AuditDateTime expr=%{TIME}
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ticketportal;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Daniel
 */
public class Ledger {
    
    public static HashMap<Integer, Integer> customerTicktetMap ;
    
    public static  ArrayList<Customer> customerArrayList ;
    public static  ArrayList<Ticket> ticketArrayList;
    public static HashMap<String, Integer> customerLastNameIdMap ;
    public static HashMap<String, Integer> ticketDestinationIdMap ;

    public Ledger() {
        customerTicktetMap = new HashMap<>();
        customerArrayList = new ArrayList<>();
        ticketArrayList = new ArrayList<>();
        
        customerLastNameIdMap = new HashMap<>();
        ticketDestinationIdMap = new HashMap<>();
    }
    
}
