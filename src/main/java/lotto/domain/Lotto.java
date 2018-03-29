package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final int FOURTH = 3;
    private static final int THIRD = 4;
    private static final int SECOND = 5;
    private static final int FIRST = 6;
    private List<Ticket> tickets;

    public Lotto(int numberOfTickets) {
        this.tickets = generateTicket(numberOfTickets);
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

    public String[] determineResult(List<Number> winningNumbers) {
        List<Integer> matchesCounts = Matcher.compareTickets(winningNumbers, tickets);
        String fourth = String.valueOf(matchesCounts.stream().filter(count -> count.equals(FOURTH)).count());
        String third = String.valueOf(matchesCounts.stream().filter(count -> count.equals(THIRD)).count());
        String second = String.valueOf(matchesCounts.stream().filter(count -> count.equals(SECOND)).count());
        String first = String.valueOf(matchesCounts.stream().filter(count -> count.equals(FIRST)).count());
        return new String[]{fourth, third, second, first};
    }
}