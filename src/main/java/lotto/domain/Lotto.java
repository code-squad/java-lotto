package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author sangsik.kim
 */
public class Lotto {
    private List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validation(numbers);
        this.numbers = numbers.stream()
                .mapToInt(Integer::intValue)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public Lotto() {
        this.numbers = AutoSelector.generate();
    }

    private void validation(List<Integer> numbers) {
        Set<Integer> removeDuplicates = new HashSet(numbers);
        if (removeDuplicates.size() != 6) {
            throw new IllegalArgumentException("INVALID NUMBERS");
        }
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.numbers.stream()
                .anyMatch(number -> number.equals(lottoNumber));
    }

    public Rank match(WinningLotto winningLotto) {
        return Rank.valueOf(Math.toIntExact(this.numbers
                .stream()
                .filter(lottoNumber -> winningLotto.contains(lottoNumber))
                .count()), this.numbers.contains(winningLotto.getBonusNumber()));
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
