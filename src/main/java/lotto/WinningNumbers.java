package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static common.Constant.THE_NUMBER_OF_LOTTO_NUMBERS;

public class WinningNumbers {
    private final List<LottoNumber> winningNumbers;

    public WinningNumbers(int[] winningNumbers) {
        this.winningNumbers = getLottoNumbers(winningNumbers);
        if (this.winningNumbers.size() != THE_NUMBER_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException();
        }
    }

    private List<LottoNumber> getLottoNumbers(int[] winningNumbers) {
        return Arrays.stream(winningNumbers)
                     .distinct()
                     .mapToObj(LottoNumber::new)
                     .collect(Collectors.toList());
    }

    public boolean contain(LottoNumber number) {
        return winningNumbers.stream()
                             .anyMatch(i -> i.equals(number));
    }
}
