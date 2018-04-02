package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    static final int LOTTO_PRICE = 1000;
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

    public Result determineResult(List<Number> winningNumbers) {
        return new Result(tickets, new Ticket(winningNumbers.subList(0, 6)), winningNumbers.get(6));
    }
}