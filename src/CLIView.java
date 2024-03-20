import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;

public class CLIView {
    public String askName() {
        String name = null;
        Scanner scan = new Scanner(System.in);
        do{
            System.out.print("Введите имя : ");
            name = scan.nextLine();
            if (name == null) {
                System.out.print("Это поле не может быть пустым, введите имя : ");
            }
        }while(name == null || name.isEmpty());

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
        }while (price <= 0);

        return price;
    }
    public TicketType askTicketType(){
        TicketType type;
        Scanner scan = new Scanner (System.in);
        System.out.println("Выберите один из статусов : " +
                "\n1." + TicketType.VIP +
                "\n2." + TicketType.BUDGETARY +
                "\n3." + TicketType.CHEAP +
                "\n4." + TicketType.USUAL);
        do
        {
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
                    System.out.print("Выбериет тип из списка : ");
                    continue;
            }
            break;
        }while(true);
        return type;
    }
    public String askPerson(){
        String person;
        Person pers  = new Person();
        do{
            pers.setPassportID();
            person = pers.getPassportID();
            if (person == null){
                System.out.print("Поле person не может быть пустым!");
            }
        }while(person == null || person.isEmpty());

        return person;
    }
}
// Главный switch для выбора команд ( из мейн )
// Ввод / вывод происходит здесь
// Получение данных в CLIView
// 1. switch ( представлен в Main )
// 2. отдельные команды ( удаления, добавление, ... )
// 3. методы для получения полей ( пример : askName )

