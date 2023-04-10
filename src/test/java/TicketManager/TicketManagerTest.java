package TicketManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {

    @Test
    public void testSortTickets() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(1, "Moskow", "Paris", 500, 188);
        Ticket ticket2 = new Ticket(2, "Paris", "Moskow", 550, 190);
        Ticket ticket3 = new Ticket(3, "Paris", "Moskow", 200, 188);
        Ticket ticket4 = new Ticket(4, "Minsk", "Sochi", 220, 160);
        Ticket ticket5 = new Ticket(5, "Moskow", "Paris", 400, 192);
        Ticket ticket6 = new Ticket(6, "Moskow", "Paris", 440, 191);
        Ticket ticket7 = new Ticket(7, "SPB", "Murmansk", 200, 56);
        Ticket ticket8 = new Ticket(8, "Murmansk", "SPB", 202, 58);

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

    @Test
    public void testNoRequiredTicket() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(1, "Moskow", "Paris", 500, 188);
        Ticket ticket2 = new Ticket(2, "Paris", "Moskow", 550, 190);
        Ticket ticket3 = new Ticket(3, "Paris", "Moskow", 200, 188);
        Ticket ticket4 = new Ticket(4, "Minsk", "Sochi", 220, 160);
        Ticket ticket5 = new Ticket(5, "Moskow", "Paris", 400, 192);
        Ticket ticket6 = new Ticket(6, "Moskow", "Paris", 440, 191);
        Ticket ticket7 = new Ticket(7, "SPB", "Murmansk", 200, 56);
        Ticket ticket8 = new Ticket(8, "Murmansk", "SPB", 202, 58);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("Moskow", "Sochi");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindsOneTicket() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(1, "Moskow", "Paris", 500, 188);
        Ticket ticket2 = new Ticket(2, "Paris", "Moskow", 550, 190);
        Ticket ticket3 = new Ticket(3, "Paris", "Moskow", 200, 188);
        Ticket ticket4 = new Ticket(4, "Minsk", "Sochi", 220, 160);
        Ticket ticket5 = new Ticket(5, "Moskow", "Paris", 400, 192);
        Ticket ticket6 = new Ticket(6, "Moskow", "Paris", 440, 191);
        Ticket ticket7 = new Ticket(7, "SPB", "Murmansk", 200, 56);
        Ticket ticket8 = new Ticket(8, "Murmansk", "SPB", 202, 58);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket8};
        Ticket[] actual = manager.findAll("Murmansk", "SPB");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortToIdTickets() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(9, "Moskow", "Paris", 200, 188);
        Ticket ticket2 = new Ticket(10, "Moskow", "Paris", 201, 190);
        Ticket ticket3 = new Ticket(11, "Moskow", "Paris", 205, 188);
        Ticket ticket4 = new Ticket(12, "Moskow", "Paris", 220, 180);
        Ticket ticket5 = new Ticket(13, "Moskow", "Paris", 250, 192);
        Ticket ticket6 = new Ticket(14, "Moskow", "Paris", 440, 191);
        Ticket ticket7 = new Ticket(15, "Moskow", "Paris", 460, 200);
        Ticket ticket8 = new Ticket(16, "Moskow", "Paris", 500, 201);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8};
        Ticket[] actual = manager.findAll("Moskow", "Paris");

        Assertions.assertArrayEquals(expected, actual);

    }


    @Test
    public void testFindsSortOfDuration() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(1, "Moskow", "Paris", 500, 188);
        Ticket ticket2 = new Ticket(2, "Moskow", "Paris", 550, 190);
        Ticket ticket3 = new Ticket(3, "Moskow", "Paris", 200, 189);
        Ticket ticket4 = new Ticket(4, "Minsk", "Sochi", 220, 160);
        Ticket ticket5 = new Ticket(5, "Moskow", "Paris", 400, 192);
        Ticket ticket6 = new Ticket(6, "Moskow", "Paris", 440, 191);
        Ticket ticket7 = new Ticket(7, "SPB", "Murmansk", 200, 56);
        Ticket ticket8 = new Ticket(8, "Murmansk", "SPB", 202, 58);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket1, ticket3, ticket2, ticket6, ticket5};
        Ticket[] actual = manager.findAll("Moskow", "Paris", new TicketByDurationAscComparator());

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testNotFindsTicket() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(1, "Moskow", "Paris", 500, 188);
        Ticket ticket2 = new Ticket(2, "Moskow", "Paris", 550, 190);
        Ticket ticket3 = new Ticket(3, "Moskow", "Paris", 200, 189);
        Ticket ticket4 = new Ticket(4, "Minsk", "Sochi", 220, 160);
        Ticket ticket5 = new Ticket(5, "Moskow", "Paris", 400, 192);
        Ticket ticket6 = new Ticket(6, "Moskow", "Paris", 440, 191);
        Ticket ticket7 = new Ticket(7, "SPB", "Murmansk", 200, 56);
        Ticket ticket8 = new Ticket(8, "Murmansk", "SPB", 202, 58);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("Paris", "Moskow", new TicketByDurationAscComparator());

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindsSortOfPrice() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(1, "Moskow", "Paris", 500, 188);
        Ticket ticket2 = new Ticket(2, "Moskow", "Paris", 550, 190);
        Ticket ticket3 = new Ticket(3, "Moskow", "Paris", 200, 189);
        Ticket ticket4 = new Ticket(4, "Minsk", "Sochi", 220, 160);
        Ticket ticket5 = new Ticket(5, "Moskow", "Paris", 400, 192);
        Ticket ticket6 = new Ticket(6, "Moskow", "Paris", 440, 191);
        Ticket ticket7 = new Ticket(7, "SPB", "Murmansk", 200, 56);
        Ticket ticket8 = new Ticket(8, "Murmansk", "SPB", 202, 58);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket3, ticket5,ticket6, ticket1, ticket2};
        Ticket[] actual = manager.findAll("Moskow", "Paris", new TicketByPriceAscComparator());

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testNotFindsPriceTicket() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(1, "Moskow", "Paris", 500, 188);
        Ticket ticket2 = new Ticket(2, "Moskow", "Paris", 550, 190);
        Ticket ticket3 = new Ticket(3, "Moskow", "Paris", 200, 189);
        Ticket ticket4 = new Ticket(4, "Minsk", "Sochi", 220, 160);
        Ticket ticket5 = new Ticket(5, "Moskow", "Paris", 400, 192);
        Ticket ticket6 = new Ticket(6, "Moskow", "Paris", 440, 191);
        Ticket ticket7 = new Ticket(7, "SPB", "Murmansk", 200, 56);
        Ticket ticket8 = new Ticket(8, "Murmansk", "SPB", 202, 58);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("Paris", "Moskow", new TicketByDurationAscComparator());

        Assertions.assertArrayEquals(expected, actual);
    }

}
