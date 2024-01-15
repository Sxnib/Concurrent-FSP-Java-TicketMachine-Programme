/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ticketprintingsystem;

/**
 *
 * @author SuniB
 */
public class TicketMachine implements ServiceTicketMachine {
    private int paperLevel;
    private int tonerLevel;
    private final int maxPaperLevel;
    private final int maxTonerLevel;

    public TicketMachine(int maxPaperLevel, int maxTonerLevel) {
        this.maxPaperLevel = maxPaperLevel;
        this.maxTonerLevel = maxTonerLevel;
        this.paperLevel = maxPaperLevel; 
        this.tonerLevel = maxTonerLevel; 
    }

    @Override
    public synchronized Ticket issueTicket() throws OutOfResourceException {
        if (paperLevel <= 0) {
            throw new OutOfResourceException("Out of paper");
        }
        if (tonerLevel <= 0) {
            throw new OutOfResourceException("Out of toner");
        }
        paperLevel--; 
        tonerLevel--;
        return new Ticket(50.0);
    }

    @Override
    public synchronized boolean hasSufficientPaper() {
        return paperLevel > 0;
    }

    @Override
    public synchronized boolean hasSufficientToner() {
        return tonerLevel > 0;
    }

    @Override
    public synchronized void refillPaper() {
        paperLevel = maxPaperLevel;
    }

    @Override
    public synchronized void changeToner() {
        tonerLevel = maxTonerLevel;
    }

    public synchronized int getPaperLevel() {
        return paperLevel;
    }

    public synchronized int getTonerLevel() {
        return tonerLevel;
    }
}

class OutOfResourceException extends Exception {
    public OutOfResourceException(String message) {
        super(message);
    }
}