package lotto.domain;

import java.util.List;

public class Ticket {
    private final List<Number> ticket;

    Ticket(List<Number> numbers) {
        this.ticket = numbers;
    }

    int countMatchPerTicket(List<Number> winningNums) {
        return (int) ticket.stream().filter(winningNums::contains).count();
    }

    public String getTicketString() {
        return Parser.parseToPrintable(ticket);
    }
}