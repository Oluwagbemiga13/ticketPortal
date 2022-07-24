/*
 *  @ Danile Rakovský
$RequestHeader set AuditDate expr=%{TIME_YEAR}-%{TIME_MON}-%{TIME_DAY}
$RequestHeader set AuditDateTime expr=%{TIME}
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//Hashmap loginPositionMap not functioning?? Create acc functioning
package com.mycompany.ticketportal;


import static com.mycompany.ticketportal.GuiHandler.createFirstWindow;
import static com.mycompany.ticketportal.Ledger.customerArrayList;
import static com.mycompany.ticketportal.Ledger.customerLastNameIdMap;
import static com.mycompany.ticketportal.Ledger.customerTicktetMap;
import static com.mycompany.ticketportal.Ledger.loginPasswordMap;
import static com.mycompany.ticketportal.Ledger.loginPositionMap;
import static com.mycompany.ticketportal.Ledger.privateCustomerArrayList;
import static com.mycompany.ticketportal.Ledger.ticketArrayList;
import static com.mycompany.ticketportal.Ledger.ticketDestinationIdMap;
import static com.mycompany.ticketportal.Printer.printTicketInfo;
import static com.mycompany.ticketportal.Printer.searchCustomerPrint;
import static com.mycompany.ticketportal.Printer.searchTicketPrint;
//import static com.mycompany.ticketportal.Vendor.returnTicket;
import static com.mycompany.ticketportal.GuiHandler.createCustomerMainMenuWindow;
import java.awt.BorderLayout;
import java.util.Scanner;
import javax.swing.JFrame;


/**
 *
 * @author Daniel
 */
public class TicketPortal {
    
    public static Customer logedInCustomer = null;
    public static PrivateCustomer privateLogedInCustomer = null;
    public static Ticket currentTicket = null;
    
    public static PrivateCustomer createPrivateCustomer(String firstName, String lastName, String login, String password){
        
        //System.out.println("Enter first name: ");
        //Scanner scanner = new Scanner(System.in);
        //String privateFirstName = scanner.nextLine();
        
        //System.out.println("Enter last name: ");
        //String privateLastName = scanner.nextLine();
        
        //System.out.println("Enter login: ");
        //String login = scanner.nextLine();
        
        //System.out.println("Enter password: ");
        //String privatePassword = scanner.nextLine();
        
        String privatePassword = password;
        String privateFirstName = firstName;
        String privateLastName =   lastName; 
        
        loginPasswordMap.put(login, password);
        
        return new PrivateCustomer(privatePassword,  login,  privateFirstName, privateLastName);
    
    }
    
    // Method creating customer from form input
    public static Customer createCustomer(){
        
        int privateCustomerArrayListPosition = privateCustomerArrayList.size() - 1;
        PrivateCustomer p = Ledger.privateCustomerArrayList.get(privateCustomerArrayListPosition);
        
        System.out.println("\nMethod createCustomer() ");
                
        String firstNameCreate = p.privateFirstName;
        
        String lastNameCreate = p.privateLastName;

        return new Customer(firstNameCreate, lastNameCreate);
    }
    
    // Method combining createPrivateCustomer() and createCustomer() 
    public static void createAcc(String firstName, String lastName,String login, String password){
        createPrivateCustomer( firstName, lastName, login, password);
        createCustomer();
    }
    
    public static Ticket createTicket(){
        
        System.out.println("\nMethod createTicket()");
        System.out.println("Enter destination: ");
        Scanner scanner = new Scanner(System.in);
        String destinationCreate = scanner.nextLine();
        
        System.out.println("Enter price: ");
        
        // Handling worng input
        while(!scanner.hasNextInt()){
            System.out.println("Not integer, try again: ");
            scanner.nextLine();
        }
        int priceCreate = scanner.nextInt();
        
        System.out.println("\n");

        return new Ticket( destinationCreate,priceCreate);
    }
    
    public static Customer searchCustomer(){
        String lastName;
        Customer c = null;
        
        System.out.println("\nMethod searching Customer ID by last name.");
        System.out.println("Enter last name: ");
        Scanner scanner = new Scanner(System.in);
        lastName = scanner.nextLine();
        
        if(customerLastNameIdMap.containsKey(lastName)){
            int idOfCustomer = customerLastNameIdMap.get(lastName);
            c = customerArrayList.get(idOfCustomer);

        }
        else{
            System.out.println("Last name not found.");
        }
 
        return c;
    }
    
    public static Ticket searchTicket(String destination){
        Ticket t = null;
        /*
        System.out.println("\nMethod searching Ticket by destination.");
        System.out.println("Enter destination: ");
        Scanner scanner = new Scanner(System.in);
        destination = scanner.nextLine();
        */
        if(ticketDestinationIdMap.containsKey(destination)){
            int idOfTicket = (ticketDestinationIdMap.get(destination));
            t = ticketArrayList.get(idOfTicket);
            Printer.printTicketInfo(t);
        }
        else{
            System.out.println("\nDestination not found.");
        }
        
        return t;
    }
    
    public static void logIn(String login, String password){
        if(loginPasswordMap.containsKey(login)){
            if (loginPasswordMap.get(login).equals(password)){
                System.out.println("You have been loged in.");
                int position = loginPositionMap.get(login);
                logedInCustomer = customerArrayList.get(position);
                privateLogedInCustomer = privateCustomerArrayList.get(position);
                System.out.println("Login: " + privateLogedInCustomer.login);
                System.out.println("Customer : " + logedInCustomer.firstName + " " + logedInCustomer.lastName);
                createCustomerMainMenuWindow();
                
            }
            else {
               System.out.println("Incorect login or password."); 
            }     
        }
        else{
                System.out.println("Login doesn´t exist.");
        }
        
    }
    
    
    

public static void main(String [] args){
    System.out.println("Hello");
    //Scanner scanner = new Scanner(System.in);

    createFirstWindow();

    Ledger ledger = new Ledger();
    
    Vendor vendor = new Vendor();
    
    Ticket testTicket = new Ticket("Lagos", 20000);
    
    System.out.println(customerTicktetMap.values());
    
    //createAcc();
    createTicket();

    printTicketInfo(ticketArrayList.get(0));
    
    //TEST SELL
    vendor.sell(customerArrayList.get(0),ticketArrayList.get(0));
    
    printTicketInfo(ticketArrayList.get(0));
    
    //System.out.println(searchCustomer().firstName);
    searchTicketPrint();
    
    searchCustomerPrint();
    
    //returnTicket();
    
    

    }
}
