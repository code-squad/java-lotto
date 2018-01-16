package lotto.util;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class TicketNumberParser {
    private static final String DELIMITER = ", ";

    public static List<LottoNumber> parse(String numbersString) {
        return convertToInteger(parseAsStrings(numbersString));
    }

    private static List<LottoNumber> convertToInteger(String[] numberStrings) {
        List<LottoNumber> actualNumbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            actualNumbers.add(LottoNumber.newInstance(Integer.parseInt(numberString)));
        }
        return actualNumbers;
    }

    private static String[] parseAsStrings(String numberString) {
        return numberString.split(DELIMITER);
    }
}
