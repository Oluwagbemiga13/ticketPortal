/*
 *  @ Daniel Rakovský
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
