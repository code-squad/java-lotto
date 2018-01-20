package dto;

import java.util.Arrays;
import java.util.List;

public class ParsingLottoNumbers {
    private List<String> numbers;

    public ParsingLottoNumbers(String text) {
        List<String> result = Arrays.asList(text.replaceAll(" ", "").split(","));
        if (isValidNumberSize(result)) {
            this.numbers = result;
        }
    }

    private boolean isValidNumberSize(List<String> result) {
        return result.size() == LottoNumbers.LOTTO_NUMBER_SIZE;
    }

    public List<String> getNumbers() {
        return numbers;
    }
}
