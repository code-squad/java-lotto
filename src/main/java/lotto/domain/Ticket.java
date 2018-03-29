package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
    private final List<Number> ticket;

    Ticket(List<Integer> numbers) {
        this.ticket = createNumberInstance(numbers);
    }

    private static List<Number> createNumberInstance(List<Integer> numbers) {
        List<Number> ticket = new ArrayList<>();
        for (Integer number : numbers) {
            ticket.add(new Number(number));
        }
        return ticket;
    }

    int findMatch(List<Number> winningNums) {
        Integer matchCount = 0;
        for (Number number : ticket) {
            matchCount = countMatch(winningNums, number, matchCount);
        }
        return matchCount;
    }

    int countMatch(List<Number> winningNums, Number number, int matchCount) {
        if (winningNums.contains(number)) {
            return ++matchCount;
        }
        return matchCount;
    }
}
