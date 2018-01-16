package domain;

import java.util.List;

public class Tickets {
    private List<Ticket> tickets;

    public Tickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public int getNumberOfTickets() {
        return tickets.size();
    }

    public void createLottos(List<Lotto> lottos) {
        for(Ticket ticket : tickets)
            lottos.add(ticket.createLotto());
    }
}
