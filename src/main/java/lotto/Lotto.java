package lotto;

import lotto.vo.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int FIRST_IDX = 0;
    private static final int LOTTO_NUMBER_SIZE = 6;

    private static final List<Integer> seedNumbers;

    static {
        seedNumbers = IntStream
                .rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());
    }

    private Set<LottoNumber> lottoNumbers;

    private Lotto(Set<LottoNumber> lottoNumbers) {
        if (validateLottoNumber(lottoNumbers)) {
            throw new IllegalArgumentException();
        }
        this.lottoNumbers = lottoNumbers;
    }

    static Lotto of() {
        Collections.shuffle(seedNumbers);
        return Lotto.of(seedNumbers.subList(FIRST_IDX, LOTTO_NUMBER_SIZE));
    }

    static Lotto of(List<Integer> numbers) {
        return Lotto.of(numbers.stream().map(LottoNumber::new).collect(Collectors.toSet()));
    }

    private static Lotto of(Set<LottoNumber> numbers) {
        return new Lotto(numbers);
    }

    private boolean validateLottoNumber(Set<LottoNumber> lottoNumbers) {
        return lottoNumbers
                .stream()
                .filter(lottoNumber -> seedNumbers.contains(lottoNumber.toNumber()))
                .count() < LOTTO_NUMBER_SIZE;
    }

    int matchCount(Lotto winningLotto) {
        return (int) lottoNumbers
                .stream()
                .filter(number -> winningLotto.lottoNumbers.contains(number))
                .count();
    }

    boolean matchBonus(LottoNumber bonusNumber) {
        return this.lottoNumbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return lottoNumbers
                .stream()
                .map(lottoNumber -> lottoNumber.toNumber())
                .sorted()
                .map(number -> String.valueOf(number))
                .collect(Collectors.joining(", "));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto that = (Lotto) o;
        return lottoNumbers.containsAll(that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
