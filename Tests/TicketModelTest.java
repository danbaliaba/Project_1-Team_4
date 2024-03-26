import org.junit.jupiter.api.Test;
import Models.*;

import static org.junit.jupiter.api.Assertions.*;

public class TicketModelTest {

    @Test
    public void testGetCSVLine() {
        // Создаем объект TicketModel для тестирования
        TicketModel ticket = new TicketModel("Test Ticket", 100, TicketType.VIP, new Person("1234567890"));

        // Ожидаемая строка для CSV формата
        String expectedCSVLine = "Test Ticket;100;VIP;1234567890";

        // Получаем строку в формате CSV с помощью метода getCSVLine()
        String actualCSVLine = ticket.getCSVLine();

        // Сравниваем ожидаемую и фактическую строки
        assertEquals(expectedCSVLine, actualCSVLine);
    }
}
