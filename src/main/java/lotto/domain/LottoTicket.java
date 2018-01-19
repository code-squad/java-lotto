package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    private final List<LottoNumber> numbers;

    public LottoTicket(List<LottoNumber> numbers) {
        this.numbers = numbers;

        if (numbers.size() != LottoConstants.NUMBER_COUNT) {
            throw new IllegalArgumentException("the count of lotto number is wrong, count=" + numbers.size());
        }
    }

    @Override
    public String toString() {
        return "[" +
                toPlainString()
                + "]";
    }

    public String toPlainString() {
        return numbers.stream()
                        .sorted()
                        .map(Object::toString)
                        .collect(Collectors.joining(", "));
    }

    public boolean match(LottoNumber successNumber) {
        return numbers.contains(successNumber);
    }
}
