import java.util.Scanner;
import java.util.ArrayList;

import Controller.TicketController;
import Models.TicketRepository;
import Views.CLIView;

public class Main {
    public static void main(String[] args) {

        CLIView CLIView = new CLIView();

        // VAL: путь к файлу по умолчанию "src/TicketDataBase.csv"
        if (args.length == 0) {
            System.out.println("Не удалось найти путь к файлу.\n" +
                    "Используется путь по умолчанию!");
            CLIView.startProgram("src/TicketDataBase.csv");
        } else
            try {
                System.out.println("Загрузка билетов из файла...\n");
                CLIView.startProgram(args[0]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Путь к файлу указан неверно!");
            }
    }
}
