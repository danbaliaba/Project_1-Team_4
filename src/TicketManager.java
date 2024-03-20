import java.lang.reflect.Array;
import java.util.*;

public class TicketManager {

    Scanner insert = new Scanner(System.in);

    List<Ticket> ticketList = new ArrayList<>();

    int elements = 0;


    public void add(){
        Ticket ticket = new Ticket();
        ticket.setId();
        ticket.setName();
        ticket.setPrice();
        ticket.setType();
        ticket.setPerson();
        ticketList.add(ticket);
        elements++;
    }
    public void PersonSorter(){
        Collections.sort(ticketList, new personComparator());
        for(Ticket ticket : ticketList)
        {
            System.out.println(ticket.showPerson());
        }
    }
    public void showInfo(){
        System.out.println("Тип - ArrayList" );
        System.out.println("Количество элементов " + elements);
    }

    public void showList(){
        System.out.print(ticketList);

    }
    public void clearList()
    {
        ticketList.clear();
    }
    public void removeFirst(){
        System.out.print(ticketList.get(0));
        ticketList.remove(0);
        elements--;
    }
    public void removeAtIndex(){
        System.out.print("Введите индекс для удаления (начиная с 0 ) : ");
        int index = insert.nextInt();
        System.out.print(ticketList.get(index));
        ticketList.remove(index);
        elements--;

    }
    public Ticket removeById(){
        System.out.print("Введите id элемента для его удаления : ");
        long id = insert.nextInt();
        for(Ticket ticket : ticketList)
        {
            if(ticket.getId()!=id)
                continue;
            ticketList.remove(ticket);
            return ticket;
        }
        elements--;
        return null;
    }
    public Ticket updateById(){
        System.out.print("Введите id элемента, чтобы обновить его : ");
        long id = insert.nextInt();
        for(Ticket ticket : ticketList)
        {
            if(ticket.getId()!=id)
                continue;
            ticket.setName();
            ticket.setPrice();
            ticket.setType();
            ticket.setPerson();
            ticket.setId();
            return ticket;
        }
        return null;
    }

    public Ticket listSortType() {
        System.out.print("Введите минимальное значение качества : ");
        TicketType current;

        do {
            String ins = insert.nextLine();
            switch (ins) {
                case "VIP":
                    current = TicketType.VIP;
                    break;
                case "BUDGETARY":
                    current = TicketType.BUDGETARY;
                    break;
                case "CHEAP":
                    current = TicketType.CHEAP;
                    break;
                case "USUAL":
                    current = TicketType.USUAL;
                    break;
                default:
                    System.out.print("Выбериет тип из списка : ");
                    continue;
            }
            break;
        } while (true);
            if(current == TicketType.VIP)
            {
                for(Ticket ticket : ticketList)
                {
                    if (ticket.getType() == TicketType.VIP)
                        System.out.print(ticket);
                }
            }
            else if(current == TicketType.BUDGETARY)
            {
                for(Ticket ticket : ticketList)
                {
                    if (ticket.getType() == TicketType.BUDGETARY || ticket.getType() == TicketType.VIP)
                        System.out.print(ticket);
                }
            }
            else if(current == TicketType.CHEAP)
            {
                for(Ticket ticket : ticketList)
                {
                    if (ticket.getType() == TicketType.CHEAP || ticket.getType() == TicketType.BUDGETARY || ticket.getType() == TicketType.VIP)
                        System.out.print(ticket);
                }
            }
            else
            {
                System.out.print(ticketList);
            }
            return null;
    }
    public static class personComparator implements Comparator<Ticket>{
        @Override
        public int compare(Ticket o1, Ticket o2) {
            return o1.getPerson().compareTo(o2.getPerson());
        }
    }

}
