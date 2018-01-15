package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoParser {

    private final static String PARSING_SYMBOL = ",";

    public static Lotto parseLotto(String numbers) {
        if (isBlank(numbers)) throw new IllegalArgumentException();
        String[] split = numbers.split(PARSING_SYMBOL);
        if (!isNumeric(split)) throw new IllegalArgumentException();

        return LottoParser.parseLotto(toIntegerList(split));
    }

    public static Lotto parseLotto(List<Integer> numbers) {
        if (isBlank(numbers)) throw new IllegalArgumentException();
        LottoNumber[] numberArr = new LottoNumber[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            numberArr[i] = new LottoNumber(numbers.get(i));
        }
        return new Lotto(numberArr);
    }

    private static List<Integer> toIntegerList(String[] numbers) {
        return Stream.of(numbers).map(Integer::parseInt).collect(Collectors.toList());
    }

    private static boolean isBlank(String numbers) {
        return numbers == null || numbers.isEmpty();
    }

    private static boolean isBlank(List<Integer> numbers) {
        return numbers == null || numbers.isEmpty();
    }

    private static boolean isNumeric(String[] split) {
        return Stream.of(split).allMatch(LottoParser::isNumeric);
    }

    public static boolean isNumeric(String money) {
        return money.matches("^[0-9]*$");
    }
}