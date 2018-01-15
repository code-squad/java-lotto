package domain;

import dto.LottoResult;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static common.Constant.COUNT_OF_LOTTO_NUMBERS;

public class Lotto {

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        checkSizeOfLottoNumbers(numbers);
        checkDuplicatedLottoNumbers(numbers);
        this.numbers = numbers;
    }

    public Lotto(int... numbers) {
        List<LottoNumber> lottoNumbers = convertIntArrayToLottoNumbers(numbers);
        checkSizeOfLottoNumbers(lottoNumbers);
        checkDuplicatedLottoNumbers(lottoNumbers);
        this.numbers = lottoNumbers;
    }

    private List<LottoNumber> convertIntArrayToLottoNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                     .mapToObj(LottoNumber::new)
                     .collect(Collectors.toList());
    }

    private void checkDuplicatedLottoNumbers(List<LottoNumber> numbers) {
        if (hasDuplicatedLottoNumbers(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasDuplicatedLottoNumbers(List<LottoNumber> numbers) {
        return new HashSet<>(numbers).size() < numbers.size();
    }

    private void checkSizeOfLottoNumbers(List<LottoNumber> numbers) {
        if (numbers.size() != COUNT_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException();
        }
    }

    public LottoResult getWinResult(WinningNumbers winningNumbers) {
        return new LottoResult(getCountOfMatch(winningNumbers));
    }

    private int getCountOfMatch(WinningNumbers winningNumbers) {
        return (int) numbers.stream()
                            .filter(winningNumbers::contain)
                            .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
