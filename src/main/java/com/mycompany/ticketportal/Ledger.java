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
    // Customer / PrivateCustomer ArrayLists
    public static  ArrayList<PrivateCustomer> privateCustomerArrayList;
    public static  ArrayList<Customer> customerArrayList ; 
    
    // Customer / PrivateCustomer HashMaps
    public static HashMap<Integer, Integer> customerTicktetMap ;     
    public static HashMap<String, Integer> customerLastNameIdMap ;
    public static HashMap<String, String> loginPasswordMap;
    public static HashMap<String, Integer> loginPositionMap;
    
    // Ticket ArrayList
    public static  ArrayList<Ticket> ticketArrayList;
    
    // Ticket HashMaps
    public static HashMap<Ticket, String> ticketOriginMap; 
    public static HashMap<Ticket, String> ticketDestinationMap; 
    public static HashMap<String, Integer> ticketDestinationIdMap ;
    
    //Administrator ArrayList
    public static ArrayList<Administrator> administratorArrayList;
    
    //Administrator HashMaps   
    public static HashMap<String, char[]> administratorLoginPasswordMap;
    public static HashMap<String, Integer> administratorLoginPositionMap;
    
    
    public Ledger() {
        customerTicktetMap = new HashMap<>();
        customerArrayList = new ArrayList<>();
        
        ticketArrayList = new ArrayList<>();
        privateCustomerArrayList = new ArrayList<>();
        
        customerLastNameIdMap = new HashMap<>();
        ticketDestinationIdMap = new HashMap<>();
        loginPasswordMap = new HashMap<>();
        loginPositionMap = new HashMap<>();
        ticketOriginMap = new HashMap<>();
        ticketDestinationMap = new HashMap<>();
        
        administratorArrayList = new ArrayList<>();
        administratorLoginPasswordMap = new HashMap<>();
        administratorLoginPositionMap = new HashMap<>();
        
    }
    
}
