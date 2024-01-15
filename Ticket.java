/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ticketprintingsystem;

/**
 *
 * @author SuniB
 */
public class Ticket {
    private static int ticketCount = 0;
    private final int ticketNumber;
    private final double price;

   
    public Ticket(double price) {
        this.ticketNumber = ++ticketCount; 
        this.price = price;
    }

  
    public int getTicketNumber() {
        return ticketNumber;
    }

   
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
               "ticketNumber=" + ticketNumber +
               ", price=" + price +
               '}';
    }
}
