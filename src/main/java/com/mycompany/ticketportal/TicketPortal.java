/*
 *  @ Danile Rakovský
$RequestHeader set AuditDate expr=%{TIME_YEAR}-%{TIME_MON}-%{TIME_DAY}
$RequestHeader set AuditDateTime expr=%{TIME}
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package com.mycompany.ticketportal;


import static com.mycompany.ticketportal.GuiHandler.createAdminMainMenu;
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
import static com.mycompany.ticketportal.Ledger.administratorArrayList;
import static com.mycompany.ticketportal.Ledger.administratorLoginPasswordMap;
import static com.mycompany.ticketportal.Ledger.administratorLoginPositionMap;
import static com.mycompany.ticketportal.Ledger.ticketOriginMap;
import com.sun.tools.javac.Main;
import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import java.io.Console;
import java.io.IOException;
import static java.lang.String.format;
import java.util.ArrayList;
import java.util.Arrays;
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
    public static Administrator logedInAdministrator = null;
    private static String format;
    
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
        System.out.println(" Method createCustomer( " + firstNameCreate + "," + lastNameCreate + " )" );

        return new Customer(firstNameCreate, lastNameCreate);
    }
    
    // Method combining createPrivateCustomer() and createCustomer()
    // Q: Měl by tohle mít na starosti jiný objekt ???
    public static void createAcc(String firstName, String lastName, String login, String password){
        createPrivateCustomer( firstName, lastName, login, password);
        createCustomer();
    }
    
    // Method creating new Ticket
    public static Ticket createTicket(String origin, String destination, int price){
    
        return new Ticket( origin, destination, price);
    }
    
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
    
    //Method that chcecks if login and password is correct and log in Administrator
    public static void logInAdmin(String login, char[] password){
        if(administratorLoginPasswordMap.containsKey(login)){
            if (Arrays.equals(administratorLoginPasswordMap.get(login), password)){
                System.out.println("You have been loged in.");
                int position = administratorLoginPositionMap.get(login);
                /*
                System.out.println("logIn() -> var position = " + position);
                System.out.println("logIn() -> var login = " + login);
                */
                logedInAdministrator = administratorArrayList.get(position);
                System.out.println(Arrays.toString(password));
                System.out.println("Login: " + logedInAdministrator.login);
                System.out.println("Password: " + Arrays.toString(logedInAdministrator.password));
                createAdminMainMenu();
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
            if(q.origin.equals(origin) && q.destination.equals(destination) && !q.isSold){
                potentialTickets.add(q);
            }
        }
        if(!potentialTickets.isEmpty()){
            t = potentialTickets.get(0);
        }
        
        return t;
    }
    
    public static boolean doesTicketExists(String origin, String destination){
        
        boolean exists = false;
        for(int i = 0; i < ticketArrayList.size(); i++){
            Ticket q = ticketArrayList.get(i);
            if(q.origin.equals(origin) && q.destination.equals(destination) && !q.isSold){
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
           System.out.println("Origin :" +  t.origin);
           System.out.println("Destination :" +  t.destination);
        }
    
    }
    
    public static int getTicketPosition(String origin, String destination){
        int ticketPosition = 0;
        
        for(int i = 0; i < ticketArrayList.size(); i++){
            Ticket q = ticketArrayList.get(i);
            if(q.origin.equals(origin) && q.destination.equals(destination) && !q.isSold){
                ticketPosition = q.idTicket;
            }
        }
        return ticketPosition;
    }
    
    

public static void main(String [] args) throws IOException{
    System.out.println("Hello");

    createFirstWindow();

    // Q: Potřebuji inicializovat tyto objekty nebo to lze udělat jinak ???
    Ledger ledger = new Ledger();
    Vendor vendor = new Vendor();
    
    Ticket testTicket = new Ticket("Lagos", "Pardubice", 20000);
    
    
    searchCombined("Lagos", "Pardubice");
    //searchCombined("Pardubice", "Pardubice");
    
    for(int i = 0; i < 10; i++){
    createTicket("Lagos", "Pardubice",500);
    }
    
    for(int i = 0; i < 10; i++){
    createTicket("Calgary", "Pardubice",500);
    }

    for(int i = 0; i < 10; i++){
    createTicket("Calgary", "Lagos",500);
    }
    
    char[] testArr = {'d','a','n','1','2','3'};
    
    Administrator dan = new Administrator(testArr, "Admin");
    
    }
}
