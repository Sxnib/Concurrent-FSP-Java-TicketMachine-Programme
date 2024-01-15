/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ticketprintingsystem;
import java.util.Random;

/**
 *
 * @author SuniB
 */

public class Passenger implements Runnable {
    private final TicketMachine ticketMachine;

    public Passenger(TicketMachine ticketMachine) {
        this.ticketMachine = ticketMachine;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Ticket ticket = ticketMachine.issueTicket();
                    System.out.println("Passenger purchased ticket: " + ticket);
                }catch (OutOfResourceException e) {
                    System.out.println("Unable to purchase ticket: " + e.getMessage());
                    break;
                }
              
                Thread.sleep(new Random().nextInt(5000));
            }
        } catch (InterruptedException e) {
            System.out.println("Passenger was interrupted.");
            Thread.currentThread().interrupt();
        }
    }
}
