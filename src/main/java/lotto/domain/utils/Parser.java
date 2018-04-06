package lotto.domain.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

    public static List<List<Integer>> parseToLottoFormat(String input) {
        List<List<Integer>> lottoInts = new ArrayList<>();
        String[] lottoStrings = splitToLottoStrings(input);
        for (String lottoString : lottoStrings) {
            lottoInts.add(parseToIntegers(splitToNumberStrings(lottoString)));
        }
        return lottoInts;
    }

    public static String[] splitToLottoStrings(String input) {
        return input.split("\r?\n");
    }

    public static List<String> splitToNumberStrings(String numbers) throws IllegalArgumentException {
        String[] splitNumbers = numbers.split(",\\s*");
        if (splitNumbers.length != 6) {
            throw new IllegalArgumentException("6개의 숫자를 입력해 주세요.");
        }
        return new ArrayList<>(Arrays.asList(splitNumbers));
    }

    public static List<Integer> parseToIntegers(List<String> numbers) {
        List<Integer> integers = new ArrayList<>();
        for (String number : numbers) {
            integers.add(parseToInt(number));
        }
        return integers;
    }

    public static int parseToInt(String text) throws IllegalArgumentException {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(text);
        }
    }
}