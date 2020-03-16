package domain;

import dto.LottoDto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_PRICE = 1000;
    public static final String INVALID_SIZE_MSG = "사이즈가 맞지 않음";
    public static final String HAS_DUPLICATE_NUMBER_MSG = "중복된 숫자가 있음";

    private List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        if(!isValidSize(numbers)) {
            throw new RuntimeException(INVALID_SIZE_MSG);
        }
        if(!hasDuplicate(numbers)) {
            throw new RuntimeException(HAS_DUPLICATE_NUMBER_MSG);
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
}
