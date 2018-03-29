package lotto.domain;

import java.util.List;

public class Ticket {
    private final List<Number> ticket;

    Ticket(List<Number> numbers) {
        this.ticket = numbers;
    }

    int countMatch(List<Number> winningNums) {
        Integer matchCount = 0;
        for (Number number : ticket) {
            matchCount = count(winningNums, number, matchCount);
        }
        return matchCount;
    }

    private int count(List<Number> winningNums, Number number, int matchCount) {
        if (winningNums.contains(number)) {
            return ++matchCount;
        }
        return matchCount;
    }

    public String getTicketString() {
        return Parser.parseToPrintable(ticket);
    }
}