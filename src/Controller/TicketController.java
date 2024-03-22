package Controller;
import Models.TicketRepository;
public class TicketController {
    TicketRepository ticketRepo = new TicketRepository();

    public void start(){
        ticketRepo.startProgramm();
    }
    public void add(){
        ticketRepo.add();
    }
    public void showList(){
        ticketRepo.showList();
    }
    public void clear(){
        ticketRepo.clearList();
    }
    public void removeFirst(){
        ticketRepo.removeFirst();
    }
    public void removeAtIndex(){
        ticketRepo.removeAtIndex();
    }
    public void removeById(){
        ticketRepo.removeById();
    }
    public void updateById(){
        ticketRepo.updateById();
    }
    public void listSortGreaterType(){
        ticketRepo.listSortType();
    }
    public void info(){
        ticketRepo.showInfo();
    }
}
