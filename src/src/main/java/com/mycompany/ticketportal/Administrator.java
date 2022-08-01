/*
 *  @ Danile Rakovský
$RequestHeader set AuditDate expr=%{TIME_YEAR}-%{TIME_MON}-%{TIME_DAY}
$RequestHeader set AuditDateTime expr=%{TIME}
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ticketportal;

/**
 *
 * @author Daniel
 */
public class Administrator {
    

    static int arrayPosition = 0;
    String login;
    char[] password;

    
       
    public Administrator(char[] password, String login){

        this.password = password;
        this.login = login;

        Ledger.administratorArrayList.add(this);
        Ledger.administratorLoginPositionMap.put(login, arrayPosition);
        Ledger.administratorLoginPasswordMap.put(login, password);
        
        
        arrayPosition++;
        }
    
    
    
}
