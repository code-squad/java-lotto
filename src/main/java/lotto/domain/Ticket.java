package lotto.domain;

import lotto.view.Output;

import java.util.Arrays;
import java.util.List;

public class Ticket {
    static final int FIRST = 0;
    static final int LAST = 6;
    private final List<Number> ticket;

    Ticket(List<Number> numbers) {
        this.ticket = checkValid(numbers);
    }

    Ticket(Number num1, Number num2, Number num3, Number num4, Number num5, Number num6) {
        this.ticket = Arrays.asList(num1, num2, num3, num4, num5, num6);
    }

    private List<Number> checkValid(List<Number> numbers) throws IllegalArgumentException {
        if (numbers.size() != LAST) {
            Output.printMessage("6개의 숫자만 허용됩니다.");
            throw new IllegalArgumentException();
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            Output.printMessage("중복되는 숫자가 있습니다.");
            throw new IllegalArgumentException();
        }
        return numbers;
    }

    boolean contains(Number number) {
        return ticket.contains(number);
    }

    public String getTicketString() {
        return Parser.parseToPrintable(ticket);
    }
}