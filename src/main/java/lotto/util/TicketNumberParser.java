package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class TicketNumberParser {
    private static final String DELIMITER = ", ";

    public static List<Integer> parse(String numbersString) {
        return convertToInteger(parseAsStrings(numbersString));
    }

    private static List<Integer> convertToInteger(String[] numberStrings) {
        List<Integer> actualNumbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            actualNumbers.add(Integer.parseInt(numberString));
        }
        return actualNumbers;
    }

    private static String[] parseAsStrings(String numberString) {
        return numberString.split(DELIMITER);
    }
}
