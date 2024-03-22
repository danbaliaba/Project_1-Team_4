package Models;

import Views.CLIView;
import Models.TicketType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TicketRepository {
    String parseDateTime;
    int elements = 0;
    List<TicketModel> tickets = new ArrayList<>();
    int counter = 0;

    public void add() {
        CLIView cliView = new CLIView();
        tickets.add(new TicketModel(cliView.askName(), cliView.askId() + counter, cliView.askPrice(), cliView.askTicketType(), cliView.askPerson()));
        elements++;
        LocalDateTime date = LocalDateTime.now();
        parseDateTime = date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
        counter++;
    }
    public void showList() {
        for(TicketModel ticketModel : tickets){
            System.out.println(ticketModel);
        }
    }

    public void clearList() {
        tickets.clear();
        elements = 0;
    }

    public void removeFirst() { // перенести в класс Views.CLIView
        System.out.print(tickets.get(0));
        tickets.remove(0);
        elements--;
    }

    public void removeAtIndex() { // перенести в класс Views.CLIView
        Scanner insert = new Scanner(System.in);
        System.out.print("Введите индекс для удаления (начиная с 0 ) : ");
        int index = insert.nextInt();
        System.out.print(tickets.get(index));
        tickets.remove(index);
        elements--;
    }
    public void showInfo(){ // перенести в класс Views.CLIView
        System.out.println("Тип - ArrayList" );
        System.out.println("Количество элементов " + elements);
        System.out.println("Дата создания : " + parseDateTime);
    }
    public TicketModel updateById() {
        String name = null;
        int price = 0;
        TicketType type = null;
        String passportID = null;
        Scanner ins = new Scanner(System.in);
        Scanner insertName = new Scanner(System.in);
        Scanner insertPrice = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        Scanner insertPass = new Scanner(System.in);

        System.out.print("Введите id элемента, чтобы обновить его : ");
        long id = ins.nextLong();
        for (TicketModel ticket : tickets) {
            if (ticket.getId() == id) {
                int i = tickets.indexOf(ticket);
                tickets.remove(ticket);
                do {
                    System.out.print("Введите новое имя билета: ");
                    name = insertName.nextLine();
                    if (name == null) {
                        System.out.print("Это поле не может быть пустым, введите имя : ");
                    }
                } while (name.isEmpty());
                do {
                    try {
                        System.out.print("Введите новую цену билета: ");
                        price = insertPrice.nextInt();
                        if (price <= 0) {
                            System.out.println("Цена должна быть больше чем 0!");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Неправильный формат ввода!");
                        insertPrice.next();
                    }
                } while (price <= 0);
                System.out.println("Выберите один из статусов : " +
                        "\n1." + TicketType.VIP +
                        "\n2." + TicketType.BUDGETARY +
                        "\n3." + TicketType.CHEAP +
                        "\n4." + TicketType.USUAL);
                do {
                    String insert = scan.nextLine();
                    switch (insert) {
                        case "VIP":
                            type = TicketType.VIP;
                            break;
                        case "BUDGETARY":
                            type = TicketType.BUDGETARY;
                            break;
                        case "CHEAP":
                            type = TicketType.CHEAP;
                            break;
                        case "USUAL":
                            type = TicketType.USUAL;
                            break;
                        case " ":
                            type = null;
                            break;
                        default:
                            System.out.print("Выберите тип из списка : ");
                            continue;
                    }
                    break;
                } while (true);
                System.out.print("Введите новый номер паспорта: ");
                passportID = insertPass.nextLine();
                tickets.add(i, new TicketModel(name,id,price,type,passportID));

                System.out.println("Билет с id " + id + " обновлен.");
            }
            break;
        }
        return null;
    }
    public void removeById() { // перенести в класс Views.CLIView
        long id;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите id билета для удаления: ");
        try {
            id = scanner.nextLong();
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Некорректный формат id.");
            scanner.next();
            return;
        }
        for (TicketModel ticket : tickets) {
            if (ticket.getId() == id) {
                tickets.remove(ticket);
                System.out.println("Билет с id " + id + " удален.");
                break;
            }
            else {
                System.out.println("Билет с id " + id + " не найден.");
            }
        }
    }
    public TicketModel listSortType() {
        System.out.print("Введите минимальное значение качества : ");
        TicketType current;
        Scanner insert = new Scanner(System.in);
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
            for(TicketModel ticket : tickets)
            {
                if (ticket.getType() == TicketType.VIP)
                    System.out.print(ticket);
            }
        }
        else if(current == TicketType.BUDGETARY)
        {
            for(TicketModel ticket : tickets)
            {
                if (ticket.getType() == TicketType.BUDGETARY || ticket.getType() == TicketType.VIP)
                    System.out.print(ticket);
            }
        }
        else if(current == TicketType.CHEAP)
        {
            for(TicketModel ticket : tickets)
            {
                if (ticket.getType() == TicketType.CHEAP || ticket.getType() == TicketType.BUDGETARY || ticket.getType() == TicketType.VIP)
                    System.out.print(ticket);
            }
        }
        else
        {
            System.out.print(tickets);
        }
        return null;
    }
    public void startProgramm(){
        Scanner insert = new Scanner(System.in);
        System.out.println("Команда help выведет доступный список команд!");

        String vvod;
        do {
            System.out.print("Введите команду: ");
            vvod = insert.nextLine();

            switch (vvod) {
                case "help":
                    System.out.println("info : вывести информацию о коллекции\n" +
                            "show : вывести все элементы коллекции\n" +
                            "add : добавить новый элемент в коллекцию\n" +
                            "update {id} : обновить значение элемента коллекции\n" +
                            "remove_by_id {id} : удалить элемент из коллекции по id\n" +
                            "clear : очистить коллекцию\n" +
                            "remove_at {index} : удалить элемент по индексу\n" +
                            "remove_first : удалить первый элемент\n" +
                            "filter_greater_than_type {type} : вывести элементы, значение поля type которых больше заданного\n" +
                            "print_field_descending_person : вывести значения поля person всех элементов в порядке убывания");
                    break;
                case "info":
                    showInfo();
                    break;
                case "show":
                    showList();
                    break;
                case "add":
                    add();
                    break;
                case "update":
                    updateById();
                    break;
                case "remove_by_id":
                    removeById();
                    break;
                case "clear":
                    clearList();
                    break;
                case "remove_at":
                    removeAtIndex();
                    break;
                case "remove_first":
                    removeFirst();
                    break;
                case "filter_greater_than_type":
                    listSortType();
                    break;
             /*   case "print_field_descending_person": // надо доделать
                    personSorter();
                    break;*/
                case "exit":
                    System.out.println("Завершение программы.");
                    break;
                default:
                    System.out.println("Некорректная команда. Введите 'help' для списка команд.");
                    break;
            }
        } while (!vvod.equals("exit"));

        insert.close();
    }
}
