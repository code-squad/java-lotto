package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebParser {

    public static List<List<Integer>> parseToLottoInts(String input) {
        List<List<Integer>> lottoInts = new ArrayList<>();
        List<String> lottoStrings = splitToLottoStrings(input);
        for (String lottoString : lottoStrings) {
            lottoInts.add(parseToIntegers(splitToNumberStrings(lottoString)));
        }
        return lottoInts;
    }

    public static List<String> splitToLottoStrings(String input) {
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
