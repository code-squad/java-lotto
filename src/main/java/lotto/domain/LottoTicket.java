package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {
    private final Set<Integer> numbers;

    public LottoTicket(List<Integer> numbers) {
        this.numbers = setNumbers(numbers);
    }

    int match(LottoTicket ticket) {
        return (int) numbers.stream()
                .filter(ticket::contains)
                .count();
    }

    boolean contains(int expected) {
        return numbers.contains(expected);
    }

    Set<Integer> getNumbers() {
        return numbers;
    }

    private Set<Integer> setNumbers(List<Integer> numbers) {
        LottoNumbersValidator.validate(numbers);
        return new HashSet<>(numbers);
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}
