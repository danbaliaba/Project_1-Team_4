package Controller;
import Models.Person;
import Models.TicketModel;
import Models.TicketRepository;
import Models.TicketType;

import java.util.List;

public class TicketController {
    TicketRepository TicketRepository = new TicketRepository();

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

    public List<TicketModel> showListForView() {
        return TicketRepository.showList();
    }
    public void clearForView(){
        TicketRepository.clearListForController();
    }
    public void removeFirstForView(){
        TicketRepository.removeFirstForController();
    }
    public void removeAtIndexForView(int index){
        TicketRepository.removeAtIndexForController(index);
    }
    public void removeByIdForView(long id){
        TicketRepository.removeById(id);
    }
    public boolean updateByIdForView(long id){
        return TicketRepository.checkIdForUpdByID(id);
    }

    public TicketModel listSortForView(TicketType current){
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
