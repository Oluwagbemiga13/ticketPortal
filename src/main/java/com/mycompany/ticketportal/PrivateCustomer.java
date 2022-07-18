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
    
       
    public PrivateCustomer(String privatePassword, String login, String privateFirstName, String privateLastName){

        this.arrayPosition = arrayPosition;
        this.privatePassword = privatePassword;
        this.login = login;
        this.privateLastName = privateLastName;
        this.privateFirstName = privateFirstName;
        arrayPosition++;
        Ledger.privateCustomerArrayList.add(this);
        }
    
    }
    
