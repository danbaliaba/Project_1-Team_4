import static org.junit.jupiter.api.Assertions.*;
import Controller.TicketController;
import Models.TicketModel;
import Models.TicketType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class TicketControllerTest {

    private TicketController ticketController;

    @BeforeEach
    public void setUp() {
        // Создаем экземпляр TicketController перед каждым тестом
        ticketController = new TicketController("testFile.csv");
    }

    @Test
    public void testClearForView() {
        // Добавляем несколько билетов для тестирования
        ticketController.addForView("Ticket 1", 100, TicketType.VIP, "123456");
        ticketController.addForView("Ticket 2", 150, TicketType.USUAL, "789012");

        // Проверяем, что список билетов не пуст перед очисткой
        List<TicketModel> ticketsBeforeClear = ticketController.getTickeList();
        assertFalse(ticketsBeforeClear.isEmpty());
        assertEquals(2, ticketsBeforeClear.size());

        // Очищаем список билетов
        ticketController.clearForView();

        // Проверяем, что список билетов пуст после очистки
        List<TicketModel> ticketsAfterClear = ticketController.getTickeList();
        assertTrue(ticketsAfterClear.isEmpty());
    }
}
