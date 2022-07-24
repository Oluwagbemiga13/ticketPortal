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
public class GuiHandler {
    
    public static void createFirstWindow(){
        FirstWindow firstWindow = new FirstWindow();
        firstWindow.setVisible(true);
    }
    
    public static void createSearchTicketWindow(){
        SearchTicketWindow searchTicketWindow = new SearchTicketWindow();
        searchTicketWindow.setVisible(true);
    }
    
    public static void createTicketInfoWindow(){
        TicketInfoWindow ticketInfoWindow = new TicketInfoWindow();
        ticketInfoWindow.setVisible(true);
    }
    
}
