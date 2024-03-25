package Controller;

import Models.*;

import java.util.List;

public class TicketController {
    TicketRepository TicketRepository;
    CSVFileRepository CSVFileRepository;
    String filepath;

    public TicketController() {
        this.TicketRepository = new TicketRepository();
        this.CSVFileRepository = new CSVFileRepository(filepath);
        this.loadTicketsFromFile();
    }

    public List<TicketModel> getTickeList() {
        return TicketRepository.getTickets();
    }

    public void loadTicketsFromFile() {
        List<TicketModel> ticketModels = this.CSVFileRepository.loadForController();
        for (TicketModel tickets : ticketModels) {
            this.TicketRepository.add(tickets);
        }
    }

    public List<TicketModel> showListForView() {
        return TicketRepository.getTickets();
    }

    public TicketController(String filepath) {
        this.TicketRepository = new TicketRepository();
        this.CSVFileRepository = new CSVFileRepository(filepath);
    }

    public void addForView(
            String name, int price, TicketType type, String passportID) {
        Person person = new Person(passportID);
        TicketModel newTicket = new TicketModel(name, price, type, person);
        this.TicketRepository.add(newTicket);
    }

    public void addByIdForView(
            String name, int price, TicketType type, String passportID, long id) {
        Person person = new Person(passportID);
        TicketModel newTicket = new TicketModel(name, price, type, person);
        newTicket.setId(id);
        this.TicketRepository.add(newTicket);
    }

    public void personSorterForView() { // связь метода printFieldDescendingPerson с TicketRepository
        TicketRepository.personSorter();
    }

    public TicketType ticketTypeArgsInResultForView(String upperCaseArgsIn) {
        TicketType result = null;
        switch (upperCaseArgsIn) {
            case "VIP":
                result = TicketType.VIP;
                break;
            case "BUDGETARY":
                result = TicketType.BUDGETARY;
                break;
            case "CHEAP":
                result = TicketType.CHEAP;
                break;
            case "USUAL":
                result = TicketType.USUAL;
                break;
            default:
                result = null;
                break;
        }
        return result;
    }

    public void saveForView(String filepath) {
        CSVFileRepository.saveForController(filepath, TicketRepository.tickets);
    }

    public void clearForView() {
        TicketRepository.clearListForController();
    }

    public void removeFirstForView() {
        TicketRepository.removeFirstForController();
    }

    public void removeAtIndexForView(int index) {
        TicketRepository.removeAtIndexForController(index);
    }

    public void removeByIdForView(long id) {
        TicketRepository.removeById(id);
    }


    public TicketModel listSortForView(TicketType current) {
        TicketModel ticket = TicketRepository.listSortTypeForController(current);
        return ticket;
    }

    public String getParseDateTimeForView() {
        return TicketRepository.getParseDateTime();
    }

    public String setParseDateTimeForView() {
        return TicketRepository.getParseDateTime();
    }

    public int getElementsForView() {
        return TicketRepository.getElements();
    }

}
