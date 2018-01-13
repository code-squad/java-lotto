package lotto;

import java.util.List;
import java.util.stream.Collectors;

import static common.Constant.THE_NUMBER_OF_LOTTO_NUMBERS;

public class LottoNumbers {

    private final List<LottoNumber> numbers;

    public LottoNumbers(List<LottoNumber> numbers) {
        checkArgument(numbers);
        this.numbers = numbers;
    }

    private void checkArgument(List<LottoNumber> numbers) {
        checkCountOfLottoNumbers(numbers);
        checkDuplicatedLottoNumbers(numbers);
    }

    private void checkDuplicatedLottoNumbers(List<LottoNumber> numbers) {
        if (hasDuplicatedLottoNumbers(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasDuplicatedLottoNumbers(List<LottoNumber> numbers) {
        return getDistinctNumbersSize(numbers) < numbers.size();
    }

    private int getDistinctNumbersSize(List<LottoNumber> numbers) {
        return numbers.stream()
                      .distinct()
                      .collect(Collectors.toList())
                      .size();
    }

    private void checkCountOfLottoNumbers(List<LottoNumber> numbers) {
        if (numbers.size() != THE_NUMBER_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException();
        }
    }

    public Result getWinResult(WinningNumbers winningNumbers) {
        return new Result(getCountOfMatch(winningNumbers));
    }

    private int getCountOfMatch(WinningNumbers winningNumbers) {
        return (int) numbers.stream()
                            .filter(winningNumbers::contain)
                            .count();
    }
}
