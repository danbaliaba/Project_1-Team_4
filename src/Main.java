import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // реализовать все взаимодействие с пользователем в классе CLIView
        Scanner insert = new Scanner(System.in);

        /* VAL: я не знаю, почему, но это работает только так. Я не могу вписать название и
        оно работает только с записью CLIView CLIView = New CLIView, я пока не нашла других решений.
        Иначе оно требует все методы, вызываемые из класса CLIView сделать статическими.
        Так что пока это костыль
         */
        CLIView CLIView = new CLIView();

        // VAL: Этот код ещё дописывается
//        String ticketCSVList = String.valueOf(args[0]); // VAL: преобразую аргументу в строку и использую это в кач-ве аргументов метода
//        CLIView.addTicketFromCVS(ticketCSVList); // VAL: вызываю метод, который берёт аргументы при запуске в кач-ве указания адреса CSV файла


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
                    /* VAL: я починила вызов методов, раньше использовалось ticketManager.имя_метода,
                    что устарело, т.к. теперь команды хранятся в CLIView */
                case "info":
                    CLIView.showInfo();
                    break;
                case "show":
                    CLIView.showList();
                    break;
                case "add":
                    CLIView.add();
                    break;
                case "update":
                    CLIView.updateById();
                    break;
                case "remove_by_id":
                    CLIView.removeById();
                    break;
                case "clear":
                    CLIView.clearList();
                    break;
                case "remove_at":
                    CLIView.removeAtIndex();
                    break;
                case "remove_first":
                    CLIView.removeFirst();
                    break;
                case "filter_greater_than_type":
                    CLIView.listSortType();
                    break;
                case "print_field_descending_person":
//                    CLIView.personSorter(); VAL: пока что так, потому что метод не прописан, потом можно его "открыть"
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
