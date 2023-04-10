package TicketManager;

import java.util.Comparator;

public class TicketByIdAscComparator implements Comparator<Ticket> {
    public int compare(Ticket o1, Ticket o2) {
        return o1.getId() - o2.getId();
    }
}
