import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CLIView {
    int elements = 0;
    List<Ticket> tickets = new ArrayList<>();

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
        String person;
        Person pers = new Person();
        do {
            pers.setPassportID();
            person = pers.getPassportID();
            if (person == null) {
                System.out.print("Поле person не может быть пустым!");
            }
        } while (person == null || person.isEmpty());

        return person;
    }

    public long askId() {
        int counter = 0;
        long id;
        id = 2348972 + counter;
        counter++;

        return id;
    }

    public void add() {
        tickets.add(new Ticket(askName(), askId(), askPrice(), askTicketType(), askPerson()));
        elements++;
    }

    public void showList() {
        System.out.print(tickets);
    }

    public void clearList() {
        tickets.clear();
        elements = 0;
    }

    public void removeFirst() { // перенести в класс CLIView
        System.out.print(tickets.get(0));
        tickets.remove(0);
        elements--;
    }

    public void removeAtIndex() { // перенести в класс CLIView
        Scanner insert = new Scanner(System.in);
        System.out.print("Введите индекс для удаления (начиная с 0 ) : ");
        int index = insert.nextInt();
        System.out.print(tickets.get(index));
        tickets.remove(index);
        elements--;
    }

    public void removeById() { // перенести в класс CLIView
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
        boolean removed = false;
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                tickets.remove(ticket);
                System.out.println("Билет с id " + id + " удален.");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("Билет с id " + id + " не найден.");
        }
    }

    public Ticket updateById() {
        String name = null;
        int price = 0;
        TicketType type = null;
        String passportID = null;
        Scanner ins = new Scanner(System.in);
        System.out.print("Введите id элемента, чтобы обновить его : ");
        long id = ins.nextInt();
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                Scanner insertName = new Scanner(System.in);
                System.out.print("Введите новое имя билета: ");
                name = insertName.nextLine();
                if (!name.isEmpty()) {
                    Scanner scan = new Scanner(System.in);
                    do {
                        System.out.print("Введите имя : ");
                        name = scan.nextLine();
                        if (name == null) {
                            System.out.print("Это поле не может быть пустым, введите имя : ");
                        }
                    } while (name.isEmpty());
                }
                System.out.print("Введите новую цену билета: ");
                Scanner insertPrice = new Scanner(System.in);
                price = insertPrice.nextInt();
                do {
                    try {
                        System.out.print("Введите цену : ");
                        price = insertPrice.nextInt();
                        if (price <= 0) {
                            System.out.println("Цена должна быть больше чем 0!");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Неправильный формат ввода!");
                        insertPrice.next();
                    }
                } while (price <= 0);
                System.out.print("Введите новый тип билета (VIP, USUAL, BUDGETARY, CHEAP): ");
                String typeStr = ins.nextLine();
                if (!typeStr.isEmpty()) {
                    do {
                        switch (typeStr) {
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
                }
                Scanner insertPassport = new Scanner(System.in);
                do {
                    System.out.print("Введите новый номер паспорта: ");
                    passportID = insertPassport.nextLine();
                    if (passportID.length() >= 4) {
                        System.out.println("Номер паспорта должен содержать не менее 4 символов.");
                    }
                } while (passportID.isEmpty());
                System.out.println("Билет с id " + id + " обновлен.");
            }
        }
        tickets.add(new Ticket(name, id, price, type, passportID ));

        return null;
    }
}
// Главный switch для выбора команд ( из мейн )
// Ввод / вывод происходит здесь
// Получение данных в CLIView
// 1. switch ( представлен в Main )
// 2. отдельные команды ( удаления, добавление, ... )
// 3. методы для получения полей ( пример : askName )

