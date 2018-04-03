package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<Ticket> tickets;

    public Lotto(int ticketsBought) {
        this.tickets = generateTicket(ticketsBought);
    }

    private List<Ticket> generateTicket(int numberOfTickets) {
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            tickets.add(new Ticket(RandomDrawer.newInstance().drawNumber()));
        }
        return tickets;
    }

    public List<String> showPurchase() {
        List<String> receipt = new ArrayList<>();
        for (Ticket ticket : tickets) {
            receipt.add(ticket.getTicketString());
        }
        return receipt;
    }

    List<Match> createMatch(WinningLotto winningLotto) {
        List<Match> matches = new ArrayList<>();
        for (Ticket ticket : tickets) {
            matches.add(winningLotto.createMatch(ticket));
        }
        return matches;
    }

    int getSize() {
        return tickets.size();
    }
}