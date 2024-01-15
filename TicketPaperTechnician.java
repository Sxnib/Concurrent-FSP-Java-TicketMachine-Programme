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
public class TicketPaperTechnician implements Runnable {
    private final TicketMachine ticketMachine;

    public TicketPaperTechnician(TicketMachine ticketMachine) {
        this.ticketMachine = ticketMachine;
    }

    @Override
    public void run() {
        try {
            int attempts = 3;
            while (!Thread.currentThread().isInterrupted() && attempts > 0) {
                if (!ticketMachine.hasSufficientPaper()) {
                    ticketMachine.refillPaper();
                    System.out.println("Technician refilled paper in the ticket machine.");
                }
                Thread.sleep(new Random().nextInt(5000)); 
                attempts--;
            }
        } catch (InterruptedException e) {
            System.out.println("Paper technician was interrupted.");
            Thread.currentThread().interrupt();
        }
    }
}