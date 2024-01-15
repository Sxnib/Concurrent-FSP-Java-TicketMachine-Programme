/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ticketprintingsystem;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author SuniB
 */
public class TicketPrintingSystem {
    public static void main(String[] args) {
        TicketMachine ticketMachine = new TicketMachine(100, 100); 

        List<Thread> passengerThreads = new ArrayList<>();
        for (int i = 0; i < 5; i++) { 
            Passenger passenger = new Passenger(ticketMachine);
            Thread thread = new Thread(passenger, "Passenger-" + (i + 1));
            passengerThreads.add(thread);
            thread.start();
        }

        Thread paperTechnicianThread = new Thread(new TicketPaperTechnician(ticketMachine), "PaperTechnician");
        Thread tonerTechnicianThread = new Thread(new TicketTonerTechnician(ticketMachine), "TonerTechnician");
        paperTechnicianThread.start();
        tonerTechnicianThread.start();

        try {
            for (Thread t : passengerThreads) {
                t.join();
            }
            paperTechnicianThread.join();
            tonerTechnicianThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("Ticket Machine Status: Paper Level = " + ticketMachine.getPaperLevel() +
                           ", Toner Level = " + ticketMachine.getTonerLevel());
    }
}