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
    
    public static void createLoginWindow(){
        
        LogInWindow logInWindow = new LogInWindow();
        logInWindow.setVisible(true); 
    }
    
    public static void createCustomerMainMenuWindow(){
        
        CustomerMainMenuWindow customerMainMenuWindow = new CustomerMainMenuWindow();
        customerMainMenuWindow.setVisible(true);  
    }
    
    public static void createSearchTicketWindow(){
        SearchTicketWindow searchTicketWindow = new SearchTicketWindow();
        searchTicketWindow.setVisible(true);
    }
    
    public static void createTicketInfoWindow(){
        TicketInfoWindow ticketInfoWindow = new TicketInfoWindow();
        ticketInfoWindow.setVisible(true);
    }
    
    public static void createAddedToCartWindow(){
        AddedToCartWindow addedToCartWindow = new AddedToCartWindow();
        addedToCartWindow.setVisible(true);
    }
    
    public static void createShoppingCartWindow(){
        ShoppingCartWindow shoppingCartWindow = new ShoppingCartWindow();
        shoppingCartWindow.setVisible(true);
        shoppingCartWindow.fillTable();
    }
    
    public static void createChangePasswordWindow(){
        ChangePasswordWindow changePasswordWindow = new ChangePasswordWindow();
        changePasswordWindow.setVisible(true);
    }
    
    public static void createAdminLogInWindow(){
        AdminLogInWindow adminLogInWindow = new AdminLogInWindow();
        adminLogInWindow.setVisible(true);
    }

    public static void createAdminMainMenu(){
        AdminMainMenu adminMainMenu = new AdminMainMenu();
        adminMainMenu.setVisible(true);
    }   
    
    public static void createAdminChangePasswordWindow(){
        AdminChangePasswordWindow adminChangePasswordWindow = new AdminChangePasswordWindow();
        adminChangePasswordWindow.setVisible(true);
    }   
    
    public static void createBuyTicketWindow(){
        BuyTicketWindow buyTicketWindow = new BuyTicketWindow();
        buyTicketWindow.setVisible(true);
    }
    
    public static void createCreateTicketWindow(){
    CreateTicketWindow createTicketWindow = new CreateTicketWindow();
    createTicketWindow.setVisible(true);
    }
    
    public static void createReturnTicketWindow(){
    ReturnTicketWindow returnTicketWindow = new ReturnTicketWindow();
    returnTicketWindow.setVisible(true);
    returnTicketWindow.fillTable();
    }
    
    public static void createViewReservationWindow(){
    ViewReservationWindow viewReservationWindow = new ViewReservationWindow();
    viewReservationWindow.setVisible(true);
    viewReservationWindow.fillTable();
    }
    
    public static void createEditCustomersWindow(){
    EditCustomersWindow editCustomersWindow = new EditCustomersWindow();
    editCustomersWindow.setVisible(true);
    editCustomersWindow.fillTable();
    }
    
    public static void createCustomerChangeValuesWindow(){
    CustomerChangeValuesWindow customerChangeValuesWindow = new CustomerChangeValuesWindow();
    customerChangeValuesWindow.setVisible(true);
    customerChangeValuesWindow.fillFields();
    }
}
