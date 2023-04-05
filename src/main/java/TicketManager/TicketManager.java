package TicketManager;

public class TicketManager {

    private TicketRepository repository;
    public TicketManager (TicketRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket product) {
        repository.add(product);
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if() {
             Ticket[] tmp = new Ticket[result.length + 1];
             for (int i = 0; i < result.length; i++) {
                 tmp[i] = result[i];
             }
             tmp[result.length] = ticket;
             result = tmp;
            }
        }
        return result;
    }


}
