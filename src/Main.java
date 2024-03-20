import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner insert = new Scanner(System.in);
        TicketManager ticketManager = new TicketManager();
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
                    ticketManager.showInfo();
                    break;
                case "show":
                    ticketManager.showList();
                    break;
                case "add":
                    ticketManager.add();
                    break;
                case "update":
                    ticketManager.updateById();
                    break;
                case "remove_by_id":
                    ticketManager.removeById();
                    break;
                case "clear":
                    ticketManager.clearList();
                    break;
                case "remove_at":
                    ticketManager.removeAtIndex();
                    break;
                case "remove_first":
                    ticketManager.removeFirst();
                    break;
                case "filter_greater_than_type":
                    ticketManager.listSortType();
                    break;
                case "print_field_descending_person":
                    ticketManager.personSorter();
                    break;
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
