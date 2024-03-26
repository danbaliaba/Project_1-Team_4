import org.junit.jupiter.api.Test;
import Models.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TicketRepositoryTest {

    @Test
    public void testAdd() {
        // Создаем объект TicketModel для тестирования
        TicketModel ticket = new TicketModel("Test Ticket", 100, TicketType.VIP, new Person("1234567890"));

        // Создаем объект TicketRepository
        TicketRepository repository = new TicketRepository();

        // Добавляем билет в репозиторий
        repository.add(ticket);

        // Получаем список билетов из репозитория
        int repositorySize = repository.getTickets().size();

        // Проверяем, что количество билетов в репозитории увеличилось на 1
        assertEquals(1, repositorySize);

    }
    @Test
    void testRemoveById() {
        // Создание экземпляра TicketRepository
        TicketRepository ticketRepository = new TicketRepository();

        // Добавление нескольких билетов для теста
        TicketModel ticket1 = new TicketModel("Ticket 1", 100, TicketType.VIP, new Person("12345"));
        TicketModel ticket2 = new TicketModel("Ticket 2", 200, TicketType.USUAL, new Person("54321"));
        ticketRepository.add(ticket1);
        ticketRepository.add(ticket2);

        // Удаление билета по ID
        long idToRemove = ticket1.getId();
        ticketRepository.removeById(idToRemove);

        // Получение списка билетов после удаления
        List<TicketModel> remainingTickets = ticketRepository.getTickets();

        // Проверка, что удаленный билет больше не содержится в списке
        assertFalse(remainingTickets.contains(ticket1));
        assertTrue(remainingTickets.contains(ticket2));
        assertEquals(1, remainingTickets.size());
    }
}
