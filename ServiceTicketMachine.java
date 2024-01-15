/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ticketprintingsystem;

/**
 *
 * @author SuniB
 */
public interface ServiceTicketMachine {

    Ticket issueTicket() throws OutOfResourceException;

    
    boolean hasSufficientPaper();


    boolean hasSufficientToner();


    void refillPaper();

    
    void changeToner();
}