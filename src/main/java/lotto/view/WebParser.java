package lotto.view;

import lotto.domain.Number;

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

    private static List<String> splitToLottoStrings(String input) { //check format
        return Arrays.asList(input.split("\r?\n"));
    }

    private static List<String> splitToNumberStrings(String numbers) throws IllegalArgumentException {
        List<String> split = Arrays.asList(numbers.split(",\\s*"));
        if (split.size() == 6) {
            return split;
        }
        Output.printMessage("당첨 번호 수(6개)가 맞지 않습니다.");
        throw new IllegalArgumentException();
    }

    private static List<Integer> parseToIntegers(List<String> numbers) {
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
            Output.printMessage("숫자만 입력해주세요.");
            throw new IllegalArgumentException();
        }
        return number;
    }

    public static String parseToPrintable(List<Number> ticket) {
        return String.join(", ", ticket.toString());
    }
}
