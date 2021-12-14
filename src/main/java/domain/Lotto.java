package domain;

import dto.LottoDto;
import vo.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    public static final String INVALID_SIZE_MSG = "사이즈가 맞지 않음";
    public static final String HAS_DUPLICATE_NUMBER_MSG = "중복된 숫자가 있음";

    private List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        if(!isValidSize(numbers)) {
            throw new IllegalArgumentException(INVALID_SIZE_MSG);
        }
        if(!hasDuplicate(numbers)) {
            throw new IllegalArgumentException(HAS_DUPLICATE_NUMBER_MSG);
        }

        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private boolean hasDuplicate(List<LottoNumber> numbers) {
        return numbers.stream().distinct().count() == LOTTO_SIZE;
    }

    private boolean isValidSize(List<LottoNumber> numbers) {
        return numbers.size() == LOTTO_SIZE;
    }

    public LottoDto toDto() {
        return new LottoDto(numbers);
    }

    public int countNumberOfMatch(Lotto winningLotto) {
        return (int) numbers.stream()
                .filter(number -> winningLotto.numbers.contains(number))
                .count();
    }

    public boolean hasBonusNumber(LottoNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }
}
