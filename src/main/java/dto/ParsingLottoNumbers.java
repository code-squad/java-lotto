package dto;

import domain.lotto.InputString;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ParsingLottoNumbers {
    private List<String> numbers;

    private ParsingLottoNumbers(List<String> result) {
        this.numbers = Optional.ofNullable(result)
                .orElse(Collections.EMPTY_LIST);

        if(!isValidNumberSize(result)){
            this.numbers = Collections.EMPTY_LIST;
        }
    }

    public static ParsingLottoNumbers of(String text) {
        return ParsingLottoNumbers.of(InputString.of(text));
    }

    public static ParsingLottoNumbers of(InputString inputString) {
        List<String> result = Optional.ofNullable(inputString)
                .map(val -> val.split(","))
                .orElse(null);

        return new ParsingLottoNumbers(result);
    }

    private static boolean isValidNumberSize(List<String> result) {
        return result.size() == LottoNumbers.LOTTO_NUMBER_SIZE;
    }

    public List<String> getNumbers() {
        return this.numbers;
    }
}
