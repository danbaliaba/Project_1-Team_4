package Models;

import Controller.TicketController;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVFileRepository {
    private String filepath;

    public CSVFileRepository(String filepath) {
        this.filepath = filepath;
    }
    TicketRepository tickets = new TicketRepository();

    public void saveForController(String filePath, List<TicketModel> tickets) {
        try (FileWriter fw = new FileWriter(filePath)) {
            for (TicketModel ticket : tickets) {
                String line = ticket.getCSVLine();
                fw.write(line);
                fw.write("\n");
            }
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }

    public List<TicketModel> loadForController() {
        List<TicketModel> ticketModels = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileInputStream(filepath))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }

                TicketModel ticket = TicketModel.getFromCSV(line);
                ticketModels.add(ticket);
            }
            return ticketModels;
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
            return null;
        }
    }
}
