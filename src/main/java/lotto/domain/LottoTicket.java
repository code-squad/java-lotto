package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {
    private Set<Integer> numbers;

    public LottoTicket(List<Integer> numbers) {
        this.numbers = new HashSet<>(numbers);
    }

    int match(LottoTicket ticket) {
        return (int) ticket.getNumbers().stream()
                .filter(number -> numbers.contains(number))
                .count();
    }

    Set<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}
