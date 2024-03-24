import java.util.Scanner;
import java.util.ArrayList;
import Controller.TicketController;
import Models.TicketRepository;
import Views.CLIView;

public class Main {
    public static void main(String[] args) {
        // реализовать все взаимодействие с пользователем в классе CLIView
        Scanner insert = new Scanner(System.in);

        /* VAL: я не знаю, почему, но это работает только так. Я не могу вписать название и
        оно работает только с записью CLIView CLIView = New CLIView, я пока не нашла других решений.
        Иначе оно требует все методы, вызываемые из класса CLIView сделать статическими.
        Так что пока это костыль
         */
     //   CLIView CLIView = new CLIView(); // теперь вызов программы происходит через TicketRepository

        // VAL: Этот код ещё дописывается
//        String ticketCSVList = String.valueOf(args[0]); // VAL: преобразую аргументу в строку и использую это в кач-ве аргументов метода
//        CLIView.addTicketFromCVS(ticketCSVList); // VAL: вызываю метод, который берёт аргументы при запуске в кач-ве указания адреса CSV файла

        CLIView CLIView = new CLIView();
        TicketController TicketController = new TicketController();
        TicketRepository TicketRepository = new TicketRepository();


        CLIView.startProgram();
    }
}
