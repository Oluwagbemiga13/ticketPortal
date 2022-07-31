/*
 *  @ Danile Rakovský
$RequestHeader set AuditDate expr=%{TIME_YEAR}-%{TIME_MON}-%{TIME_DAY}
$RequestHeader set AuditDateTime expr=%{TIME}
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


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
import static com.mycompany.ticketportal.Ledger.ticketOriginMap;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;


/**
 *
 * @author Daniel
 *  - Main class of project
 *  - Creates : Customers( Visible by user) for terminal and PrivateCustomers (Login ect. Hidden)
 *  Q: Potřebuji to vůbec zvlášť? Mám to předělat?
 *  - Creates : FirstWindow of GUI
 *  - Creates : Accounts...
 *  Q: Co přesně by měla dělat tahle třída??? 
 */
public class TicketPortal {
    
    public static Customer logedInCustomer = null;
    public static PrivateCustomer privateLogedInCustomer = null;
    public static Ticket currentTicket = null;
    
    // PrivateCustomer is Object storing variables needed for methods createCustomer(), login() and changePassword()
    // Q: Má cenu předělávat String privatePassword na Array ???
    public static PrivateCustomer createPrivateCustomer(String firstName, String lastName, String login, String password){
        
        /* As a memory of Class TicketPortal being born. 
        //System.out.println("Enter first name: ");
        //Scanner scanner = new Scanner(System.in);
        //String privateFirstName = scanner.nextLine();
        //System.out.println("Enter last name: ");
        //String privateLastName = scanner.nextLine();
        //System.out.println("Enter login: ");
        //String login = scanner.nextLine();
        //System.out.println("Enter password: ");
        //String privatePassword = scanner.nextLine();
        */
        String privatePassword = password;
        String privateFirstName = firstName;
        String privateLastName =   lastName; 
        
        loginPasswordMap.put(login, password);
        
        return new PrivateCustomer(privatePassword,  login,  privateFirstName, privateLastName);
    
    }
    
    // Object Customer contains only First and Last name of Customer.
    // Method creating customer from form PrivateCustomer 
    public static Customer createCustomer(){
        
        int privateCustomerArrayListPosition = privateCustomerArrayList.size() - 1;
        PrivateCustomer p = Ledger.privateCustomerArrayList.get(privateCustomerArrayListPosition);
        
        String firstNameCreate = p.privateFirstName;
        String lastNameCreate = p.privateLastName;
        System.out.println("""
                           
                           Method createCustomer( """ + firstNameCreate + "," + lastNameCreate + " )" );

        return new Customer(firstNameCreate, lastNameCreate);
    }
    
    // Method combining createPrivateCustomer() and createCustomer()
    // Q: Měl by tohle mít na starosti jiný objekt ???
    public static void createAcc(String firstName, String lastName, String login, String password){
        createPrivateCustomer( firstName, lastName, login, password);
        createCustomer();
    }
    
    // This method will be rebuild when Object Admin is added
    /*public static Ticket createTicket(){
        
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
    */
    // 
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
    
    // Method returning Object Ticket by destination
    public static Ticket searchTicket(String destination){
        Ticket t = null;
        
        System.out.println("\nsearchTicket para: " + destination);

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

    
    //Method that chcecks if login and password is correct and log in Customer and PrivateCustomer
    public static void logIn(String login, String password){
        if(loginPasswordMap.containsKey(login)){
            if (loginPasswordMap.get(login).equals(password)){
                System.out.println("You have been loged in.");
                int position = loginPositionMap.get(login);
                /*
                System.out.println("logIn() -> var position = " + position);
                System.out.println("logIn() -> var login = " + login);
                */
                logedInCustomer = customerArrayList.get(position);
                privateLogedInCustomer = privateCustomerArrayList.get(position);
                System.out.println("Login: " + privateLogedInCustomer.login);
                System.out.println("Customer : " + logedInCustomer.firstName + " " + logedInCustomer.lastName);
                createCustomerMainMenuWindow();
            }
        }
    }
    
    // Q: Nevím jak vyřešit vyjímku když metoda vrací null ???
    public static Ticket testSearch(String origin, String destination){
        Ticket t = null;
        
        
        System.out.println("\nsearchTicket para: " + origin  + ", " + destination);
        
        ArrayList<Ticket> potentialTickets = new ArrayList<>();
        for(int i = 0; i < ticketArrayList.size(); i++){
            Ticket q = ticketArrayList.get(i);
            if(q.origin == origin && q.destination == destination && !q.isSold){
                potentialTickets.add(q);
            }
        }
        if(potentialTickets.size() > 0){
            t = potentialTickets.get(0);
        }
        
        return t;
    }
    
    public static boolean doesTicketExists(String origin, String destination){
        ArrayList<Ticket> potentialTickets = new ArrayList<>();
        boolean exists = false;
        for(int i = 0; i < ticketArrayList.size(); i++){
            Ticket q = ticketArrayList.get(i);
            if(q.origin == origin && q.destination == destination && !q.isSold){
                exists = true;
            }
        }
        return exists;
    }
    
    public static void searchCombined(String origin, String destination){

        if(!doesTicketExists(origin , destination)){
            System.out.println("Ticket not exists");
        }
        else{
           Ticket t = testSearch(origin, destination);
           System.out.println("Destination :" +  t.destination);
        }
    
    }
    
    public static int getTicketPosition(String origin, String destination){
        int ticketPosition;
        
        for(int i = 0; i < ticketArrayList.size(); i++){
            Ticket q = ticketArrayList.get(i);
            if(q.origin == origin && q.destination == destination && !q.isSold){
                ticketPosition = q.idTicket;
            }
        }
        return ticketPosition;
    }
    
    

public static void main(String [] args){
    System.out.println("Hello");
    //Scanner scanner = new Scanner(System.in);

    createFirstWindow();

    // Q: Potřebuji inicializovat tyto objekty nebo to lze udělat jinak ???
    Ledger ledger = new Ledger();
    Vendor vendor = new Vendor();
    
    Ticket testTicket = new Ticket("Lagos", 20000, "Pardubice");
    Ticket testTicket01 = new Ticket("Pardubice", 20000, "Pardubice");
    
    searchCombined("Lagos", "Pardubice");
    //searchCombined("Pardubice", "Pardubice");
    
    char[] testArr = {'d','a','n','1','2','3'};
    
    Administrator dan = new Administrator(testArr, "Admin");
    
    }
}
