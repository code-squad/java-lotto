package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    List<Integer> numbers;

    public LottoTicket(List<Integer> integers) {
        numbers = integers;
    }

    public boolean match(Integer successNumber) {
        return numbers.contains(successNumber);
    }

    @Override
    public String toString() {
        return "[" +
                numbers.stream()
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(", "))
                + "]";
    }
}
