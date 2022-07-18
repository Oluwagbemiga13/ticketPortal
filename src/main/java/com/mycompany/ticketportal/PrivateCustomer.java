package com.mycompany.ticketportal;


import com.mycompany.ticketportal.Customer;

/*
 *  @ Danile Rakovský
$RequestHeader set AuditDate expr=%{TIME_YEAR}-%{TIME_MON}-%{TIME_DAY}
$RequestHeader set AuditDateTime expr=%{TIME}
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Daniel
 */
public class PrivateCustomer {

    int arrayPosition = 0;
    String privatePassword;
    String login;
    String privateFirstName;
    String privateLastName;
    
    public static PrivateCustomer createPrivateCustomer(Customer c){
        
        
        return new PrivateCustomer();
    }
    
    public PrivateCustomer(){

        this.arrayPosition = arrayPosition;
        arrayPosition++;
        }
    
    }
    
