import java.util.Scanner;
import java.util.ArrayList;
import Controller.TicketController;
import Models.TicketRepository;
import Views.CLIView;

public class Main {
    public static void main(String[] args) {

        CLIView CLIView = new CLIView();

        // VAL: базовый путь к файлу "resources/TicketDataBase.csv"
        if (args.length == 0){
            System.out.println("Не удалось найти путь к файлу.\n" +
                    "Загрузка билетов из файла не удалась");
        }

        CLIView.startProgram(args[0]);
    }
}
