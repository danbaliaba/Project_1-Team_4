package Views;

import Controller.TicketController;
import Models.TicketType;
import Models.Utils;

import java.util.InputMismatchException;

import java.util.Scanner;

public class CLIView {
    String filepath;
    TicketController TicketController;

    public String askName() {
        String name;
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

    public long checkID(String argsIn) {
        if (!Utils.isLong(argsIn)) {
            System.out.println("Указано неверное значение.\n");
        }
        if (Long.parseLong(argsIn) < 0) {
            System.out.println("Значение должно быть больше нуля.\n");
        }
        return Long.parseLong(argsIn);
    }

    public int askPrice() {
        int price = 0;
        Scanner scan = new Scanner(System.in);
        do {
            try {

                System.out.print("Введите цену: ");
                price = scan.nextInt();
                if (price <= 0) {
                    System.out.println("Цена должна быть больше чем 0!");
                } else {
                    return price;
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

    public void clearCommand() {
        TicketController.clearForView();
        System.out.println("Лист успешно очищен!");
    }

    public void removeFirstCommand() {
        TicketController.removeFirstForView();
    }

    public void showInfoCommand() {
        System.out.println("Тип - ArrayList");
        System.out.println("Количество элементов " + TicketController.getElementsForView());
        System.out.println("Дата создания : " + TicketController.getParseDateTimeForView());
    }

    public void removeByIdCommand(String argsIn) {
        try {
            Utils.isLong(argsIn);
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Некорректный формат id.");
            return;
        }
        long id = Long.parseLong(argsIn);
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

    public void addByIdCommand(String argsIn) {
        System.out.println("Начало работы добавления билета по ID\n");
        long newId = checkID(argsIn);
        TicketController.addByIdForView(askName(), askPrice(), askTicketType(), askPerson(), newId);
        System.out.println("Билет успешно добавлен в список!\n");
    }

    public void removeAtIndexCommand(String argsIn) {
        if (argsIn.isEmpty() || argsIn == null) {
            System.out.println("Отсутствует аргумент. Введите его после команды.");
            return;
        }
        try {
            Utils.isInt(argsIn);
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Некорректный формат индекса.");
            return;
        }
        int index = Integer.parseInt(argsIn);
        TicketController.removeAtIndexForView(index);
    }

    public void listSortTypeCommand(String argsIn) {
        if (argsIn.isEmpty() || argsIn == null) {
            System.out.println("Отсутствует аргумент. Введите его после команды.");
            return;
        }
        String upperCaseArgsIn = argsIn.toUpperCase();
        if (!Utils.isEnum(upperCaseArgsIn, TicketType.class)) {
            System.out.println("Некорректный формат или запись.");
            return;
        }

        if ((TicketController.ticketTypeArgsInResultForView(upperCaseArgsIn)) == null) {
            System.out.println("Выбранный тип не найден, попробуйте снова!");
        } else {
            System.out.println(TicketController.listSortForView(TicketController.ticketTypeArgsInResultForView(upperCaseArgsIn)));
        }
    }
    public void printFieldDescendingPerson(){ // Связь метода printFieldDescendingPerson с контроллером
        TicketController.personSorterForView();
    }

    public void showCommand() {
        System.out.println(TicketController.showListForView());
    }

    public void saveCommand(String filepath) {
        TicketController.saveForView(filepath);
    }

    public void startProgram(String filepath) {
        TicketController = new TicketController(filepath);

        TicketController.loadTicketsFromFile();

        Scanner insert = new Scanner(System.in);

        System.out.println("Команда help выведет доступный список команд!");
        String vvod;
        do {
            String[] vVodInParts = null; // VAL: объявление строки для работы далее, она будет отвечать за разделение строк при работе с некоторыми методами
            String argsIn = null; // VAL: объявление аргументов, которые будут появляться при пользовательском вводе

            System.out.print("Введите команду: ");
            vvod = insert.nextLine();


            if (vvod.contains(" ")) {
                vVodInParts = vvod.split(" ");
            }

            if (vVodInParts != null && vVodInParts.length == 2) {
                vvod = vVodInParts[0];
                argsIn = vVodInParts[1];
            }

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
                    addByIdCommand(argsIn);
                    break;
                case "remove_by_id":
                    removeByIdCommand(argsIn);
                    break;
                case "clear":
                    clearCommand();
                    break;
                case "remove_at":
                    removeAtIndexCommand(argsIn);
                    break;
                case "remove_first":
                    removeFirstCommand();
                    break;
                case "filter_greater_than_type":
                    listSortTypeCommand(argsIn);
                    break;
                case "print_field_descending_person": // доделал вывод только паспортных данных по убыванию цены
                    printFieldDescendingPerson();
                    break;
                case "save":
                    saveCommand(filepath);
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

