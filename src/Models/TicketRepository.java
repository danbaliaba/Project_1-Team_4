package Models;

import Controller.TicketController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TicketRepository {
    String parseDateTime;

    int elements = 0;
    List<TicketModel> tickets = new ArrayList<>();

    public void add(TicketModel ticketModel) {
        this.tickets.add(ticketModel);
    }

    public List<TicketModel> showList() {
     return tickets;
    }

    public void clearListForController() {
        tickets.clear();
    }

    public void removeFirstForController() {
        tickets.remove(0);
    }

    public void removeAtIndexForController(int index) {
        tickets.remove(index);
    }

    public long removeById(long id) { // перенести в класс Views.CLIView

        for (TicketModel ticket : tickets) {
            if (ticket.getId() == id) {
                tickets.remove(ticket);
                return id;
            }
            else {
                return -100;
            }
        }
        return id;
    }

    public boolean checkIdForUpdByID(long id) {

        for (TicketModel ticket : tickets) {
            if (ticket.getId() == id) {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    public TicketModel listSortTypeForController(TicketType current) {
        if(current == TicketType.VIP)
        {
            for(TicketModel ticket : tickets)
            {
                if (ticket.getType() == TicketType.VIP)
                    return ticket;
            }
        }
        else if(current == TicketType.BUDGETARY)
        {
            for(TicketModel ticket : tickets)
            {
                if (ticket.getType() == TicketType.BUDGETARY || ticket.getType() == TicketType.VIP)
                    return ticket;
            }
        }
        else if(current == TicketType.CHEAP)
        {
            for(TicketModel ticket : tickets)
            {
                if (ticket.getType() == TicketType.CHEAP || ticket.getType() == TicketType.BUDGETARY || ticket.getType() == TicketType.VIP)
                    return ticket;
            }
        }
        else
        {
            for(TicketModel ticket : tickets){
                return ticket;
            }
        }
        return null;
    }

    public String getParseDateTime() {
        return parseDateTime;
    }

    public void setParseDateTime(String parseDateTime) {
        this.parseDateTime = parseDateTime;
    }

    public int getElements() {
        return elements;
    }

    public void setElements(int elements) {
        this.elements = elements;
    }

}
