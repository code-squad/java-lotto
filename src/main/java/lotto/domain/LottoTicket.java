package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {
    private static final int HOLD_NUMBERS = 6;
    
    private Set<Integer> numbers;

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
        Set<Integer> toSet = new HashSet<>(numbers);
        if (HOLD_NUMBERS != toSet.size()) {
            throw new IllegalArgumentException("로또 번호는 중복 없이 6자리 여야 합니다.");
        }
        
        return toSet;
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}
