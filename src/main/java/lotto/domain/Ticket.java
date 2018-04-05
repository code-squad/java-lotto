package lotto.domain;

import lotto.view.Parser;

import java.util.List;

public class Ticket {
    private static final int MAX_SIZE = 6;
    private final List<Number> ticket;

    public Ticket(List<Number> numbers) {
        this.ticket = checkValid(numbers);
    }

    static List<Number> checkValid(List<Number> numbers) throws IllegalArgumentException {
        if (numbers.size() != MAX_SIZE) {
            throw new IllegalArgumentException("6개의 숫자만 허용됩니다.");
        }
        if (isDuplicate(numbers)) { //메소드 분리
            throw new IllegalArgumentException("중복되는 숫자가 있습니다.");
        }
        return numbers;
    }

    private static boolean isDuplicate(List<Number> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
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