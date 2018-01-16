package lotto.util;

import lotto.domain.LottoNumber;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoUtil {

    private final static String PARSING_SYMBOL = ",";

    public static boolean canParsing(String numbers) {
        String[] split = numbers.split(PARSING_SYMBOL);
        return isBlank(numbers) || numbers.contains(PARSING_SYMBOL) || !isNumeric(split);
    }

    public static List<LottoNumber> toLottoNumberList(String numbers) {
        Objects.requireNonNull(numbers);
        return Stream.of(numbers.split(PARSING_SYMBOL))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(number -> new LottoNumber(number))
                .collect(Collectors.toList());
    }

    private static boolean isBlank(String numbers) {
        return numbers == null || numbers.isEmpty();
    }

    private static boolean isNumeric(String[] split) {
        return Stream.of(split).allMatch(LottoUtil::isNumeric);
    }

    public static boolean isNumeric(String money) {
        return money.matches("^[0-9]*$");
    }
}