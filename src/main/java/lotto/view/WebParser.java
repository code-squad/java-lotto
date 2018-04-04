package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebParser {

    public static List<String> splitToLottoString(String input) {
        return Arrays.asList(input.split("\r?\n"));
    }

    public static List<String> splitToNumberStrings(String numbers) {
        return Arrays.asList(numbers.split(",\\s*"));
    }

    public static List<Integer> parseToIntegers(List<String> numbers) {
        List<Integer> integers = new ArrayList<>();
        for (String number : numbers) {
            integers.add(Integer.parseInt(number));
        }
        return integers;
    }
}
