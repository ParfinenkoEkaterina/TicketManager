package TicketManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {

    @Test
    public void testSortTickets() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(1, "Moskow", "Paris", 500, 55);
        Ticket ticket2 = new Ticket(2, "Paris", "Moskow", 550, 101);
        Ticket ticket3 = new Ticket(3, "Paris", "Moskow", 200, 33);
        Ticket ticket4 = new Ticket(4, "Minsk", "Sochi", 220, 44);
        Ticket ticket5 = new Ticket(5, "Moskow", "Paris", 400, 66);
        Ticket ticket6 = new Ticket(6, "Moskow", "Paris", 440, 67);
        Ticket ticket7 = new Ticket(7, "SPB", "Murmansk", 200, 37);
        Ticket ticket8 = new Ticket(8, "Murmansk", "SPB", 202, 34);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket5, ticket6, ticket1};
        Ticket[] actual = manager.findAll("Moskow", "Paris");

        Assertions.assertArrayEquals(expected, actual);

    }
}
