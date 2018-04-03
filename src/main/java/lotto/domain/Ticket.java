package lotto.domain;

import lotto.view.Output;

import java.util.List;

public class Ticket {
    private static final int MAX_SIZE = 6;
    private final List<Number> ticket;

    Ticket(List<Number> numbers) {
        this.ticket = checkValid(numbers);
    }

    static List<Number> checkValid(List<Number> numbers) throws IllegalArgumentException {
        if (numbers.size() != MAX_SIZE) {
            Output.printMessage("6개의 숫자만 허용됩니다.");
            throw new IllegalArgumentException();
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            Output.printMessage("중복되는 숫자가 있습니다.");
            throw new IllegalArgumentException();
        }
        return numbers;
    }

    int countMatches(Ticket ticket) {
        return (int) this.ticket.stream().filter(ticket::contains).count();
    }

    boolean contains(Number number) {
        return ticket.contains(number);
    }

    public String getTicketString() {
        return Parser.parseToPrintable(ticket);
    }
}