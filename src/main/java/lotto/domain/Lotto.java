package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<Ticket> tickets;

    Lotto(int numberOfTickets) {
        this.tickets = generateTicket(numberOfTickets);
    }

    List<Ticket> generateTicket(int numberOfTickets) {
        List<Ticket> tickets = new ArrayList<>();
        RandomDrawer drawer = new RandomDrawer();
        for (int i = 0; i < numberOfTickets; i++) {
            tickets.add(new Ticket(drawer.drawNumber()));
        }
        return tickets;
    }
}
