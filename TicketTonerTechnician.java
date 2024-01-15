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
public class TicketTonerTechnician implements Runnable {
    private final TicketMachine ticketMachine;

    
    public TicketTonerTechnician(TicketMachine ticketMachine) {
        this.ticketMachine = ticketMachine;
    }

    @Override
    public void run() {
        try {
            int attempts = 3;
            while (!Thread.currentThread().isInterrupted() && attempts > 0) {
                
                if (!ticketMachine.hasSufficientToner()) {
                    ticketMachine.changeToner();
                    System.out.println("Technician replaced toner in the ticket machine.");
                }
                Thread.sleep(new Random().nextInt(5000)); 
                attempts--;
            }
        } catch (InterruptedException e) {
            System.out.println("Toner technician was interrupted.");
            Thread.currentThread().interrupt();
        }
    }
} 