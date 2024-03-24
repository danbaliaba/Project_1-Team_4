package Views;

import Controller.TicketController;
import Models.TicketModel;
import Models.TicketType;
import Models.Utils;
import jdk.jshell.execution.Util;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class CLIView {


    TicketController TicketController = new TicketController();
    List<TicketModel> tickets = new ArrayList<>();

    public String askName() {
        String name = null;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.print("Введите имя : ");
            name = scan.nextLine();
            if (name == null) {
                System.out.print("Это поле не может быть пустым, введите имя : ");
            }
        } while (name == null || name.isEmpty());

        return name;
    }

    public long askID() {
        String string;
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите желаемое ID...\n");
        string = scan.nextLine();
        if (!Utils.isLong(string)){
            System.out.println("Указано неверное значение.\n");
        }
        if (Long.parseLong(string) < 0) {
            System.out.println("Значение должно быть больше нуля.\n");
        }
        return Long.parseLong(string);
    }

    public int askPrice() {
        int price = 0;
        Scanner scan = new Scanner(System.in);
        do {
            try {

                System.out.print("Введите цену : ");
                price = scan.nextInt();
                if (price <= 0) {
                    System.out.println("Цена должна быть больше чем 0!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Неправильный формат ввода!");
                scan.next();
            }
        } while (price <= 0);

        return price;
    }

    public TicketType askTicketType() {
        TicketType type;
        Scanner scan = new Scanner(System.in);
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
        return type;
    }

    public String askPerson() {
        String passportID;
        do {
            Scanner scans = new Scanner(System.in);
            System.out.print("Введите ваш идентификационный номер : ");
            passportID = scans.nextLine();
            if (passportID.length() < 4) {
                System.out.println("Длина строки должна содержать не меньше 4 символов!");
            }
        } while (passportID.length() < 4);

        return passportID;
    }

    public void clearCommand (){
        TicketController.clearForView();
        System.out.println("Лист успешно очищен!");
    }

    public void removeFirstCommand (){
        TicketController.removeFirstForView();
    }

    public void showInfoCommand() {
        System.out.println("Тип - ArrayList");
        System.out.println("Количество элементов " + TicketController.getElementsForView());
        System.out.println("Дата создания : " + TicketController.getParseDateTimeForView());
    }

    public void removeByIdCommand() {
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
        TicketController.removeByIdForView(id);
        if (id > 0) {
            System.out.println("Успешно удалён билет с ID " + id);
        } else System.out.println("Не найдено билета с ID " + id);
    }

    public void addCommand() {
        System.out.println("Начало работы добавления билета\n");
        TicketController.addForView(askName(), askPrice(), askTicketType(), askPerson());
        System.out.println("Билет успешно добавлен в список!\n");
    }

    public void addByIdCommand() {
        System.out.println("Начало работы добавления билета по ID\n");
        long newId = askID();
        TicketController.addByIdForView(askName(), askPrice(), askTicketType(), askPerson(), newId);
        System.out.println("Билет успешно добавлен в список!\n");
    }

    public void removeAtIndexCommand() {
        int index;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите желаемый индекс для удаления (начиная с 0): ");
        try {
            index = scanner.nextInt();
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Некорректный формат индекса.");
            scanner.next();
            return;
        }
        TicketController.removeAtIndexForView(index);
    }

    public void listSortTypeCommand(){
        System.out.print("Введите минимальное значение качества:\n");
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
                    System.out.print("Выберите тип из списка:\n");
                    continue;
            }
            break;
        } while (true);
        System.out.println(TicketController.listSortForView(current));
    }

    public void showCommand(){
        System.out.println(TicketController.showListForView());
    }

    public void startProgram() {
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
                    showInfoCommand();
                    break;
                case "show":
                    showCommand();
                    break;
                case "add":
                    addCommand();
                    break;
                case "update":
                    addByIdCommand();
                    break;
                case "remove_by_id":
                    removeByIdCommand();
                    break;
                case "clear":
                    clearCommand();
                    break;
                case "remove_at":
                    removeAtIndexCommand();
                    break;
                case "remove_first":
                    removeFirstCommand();
                    break;
                case "filter_greater_than_type":
                    listSortTypeCommand();
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

