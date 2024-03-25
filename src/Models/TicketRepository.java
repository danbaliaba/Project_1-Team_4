package Models;
import java.util.*;

public class TicketRepository {
    String parseDateTime;

    int elements = 0;
    public List<TicketModel> tickets = new ArrayList<>();

    public List<TicketModel> getTickets() {
        return tickets;
    }

    public List<TicketModel> setTickets(List<TicketModel> ticketsFromFile) {
        this.tickets = ticketsFromFile;
        return ticketsFromFile;
    }

    public void add(TicketModel ticketModel) {
        this.tickets.add(ticketModel);
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

    public long removeById(long id) {

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
    public void personSorter(){ // выполнение сортировки по убыванию для метода printFieldDescendingPerson
        System.out.println("PassportID отсортированный по цене (↓) :");
        tickets.sort(TicketModel::compareTo);
        for(TicketModel ticket : tickets)
        {
            System.out.println(ticket.showPerson());
        }
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

}
