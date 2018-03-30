package lotto.domain;

import lotto.view.Output;

import java.util.List;

public class Ticket {
    private static final int NUMBER_OF_DRAWS = 6;
    private final List<Number> ticket;

    Ticket(List<Number> numbers) {
        this.ticket = checkValid(numbers);
    }

    private List<Number> checkValid(List<Number> numbers) throws IllegalArgumentException {
        if (numbers.size() != NUMBER_OF_DRAWS) {
            Output.printMessage("6개의 숫자만 허용됩니다.");
            throw new IllegalArgumentException();
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            Output.printMessage("중복되는 숫자가 있습니다.");
            throw new IllegalArgumentException();
        }
        return numbers;
    }

    private boolean contains(Number number) {
        return ticket.contains(number);
    }

    int countMatchInTicket(Ticket winningTicket) {
        return (int) ticket.stream().filter(winningTicket::contains).count();
    }

    public String getTicketString() {
        return Parser.parseToPrintable(ticket);
    }
}