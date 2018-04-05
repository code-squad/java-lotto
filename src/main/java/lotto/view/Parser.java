package lotto.view;

import lotto.domain.Number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

    public static List<List<Integer>> parseToLottoFormat(String input) {
        List<List<Integer>> lottoInts = new ArrayList<>();
        List<String> lottoStrings = splitToLottoStrings(input);
        for (String lottoString : lottoStrings) {
            lottoInts.add(parseToIntegers(splitToNumberStrings(lottoString)));
        }
        return lottoInts;
    }

    public static List<String> splitToLottoStrings(String input) { //check format
        return Arrays.asList(input.split("\r?\n"));
    }

    public static List<String> splitToNumberStrings(String numbers) throws IllegalArgumentException {
        List<String> split = Arrays.asList(numbers.split(",\\s*"));
        if (split.size() == 6) {
            return split;
        }
        throw new IllegalArgumentException("당첨 번호 수(6개)가 맞지 않습니다.");
    }

    public static List<Integer> parseToIntegers(List<String> numbers) {
        List<Integer> integers = new ArrayList<>();
        for (String number : numbers) {
            integers.add(parseToInt(number));
        }
        return integers;
    }

    public static int parseToInt(String text) throws IllegalArgumentException {
        int number;
        try {
            number = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
        return number;
    }

    public static String parseToPrintable(List<Number> ticket) {
        return String.join(", ", ticket.toString());
    }
}
