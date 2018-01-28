package dto;

import domain.lotto.InputString;

import java.util.Arrays;
import java.util.List;

public class ParsingLottoNumbers {
    private List<String> numbers;

    public ParsingLottoNumbers(List<String> result) {
        this.numbers = result;
    }

    public static ParsingLottoNumbers of(String text) {
        return ParsingLottoNumbers.of(InputString.of(text));
    }

    public static ParsingLottoNumbers of(InputString inputString){
        List<String> result = inputString.split(",");
        if (isValidNumberSize(result)) {
            return new ParsingLottoNumbers(result);
        }
        return null;
    }

    private static boolean isValidNumberSize(List<String> result) {
        return result.size() == LottoNumbers.LOTTO_NUMBER_SIZE;
    }

    public List<String> getNumbers() {
        return numbers;
    }
}
