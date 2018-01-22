package lotto.util;

import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoParsingUtil {
    private final static String PARSING_SYMBOL = ",";

    public static List<LottoNumber> toLottoNumberList(String numbers) {
        Objects.requireNonNull(numbers);
        return stringToIntStream(numbers)
                .map(number -> new LottoNumber(number))
                .collect(Collectors.toList());
    }

    public static boolean match(String numbers) {
        if (LottoUtil.isBlank(numbers)) return false;
        return Arrays.asList(numbers.split(PARSING_SYMBOL)).stream()
                .map(number -> removeSpace(number))
                .allMatch(number -> LottoUtil.isNumeric(number));
    }

    public static String removeSpace(String text) {
        if (LottoUtil.isBlank(text)) return text;
        return text.trim();
    }

    public static Stream<Integer> stringToIntStream(String numbers) {
        return Arrays.asList(numbers.split(PARSING_SYMBOL)).stream()
                .map(LottoParsingUtil::removeSpace)
                .mapToInt(Integer::valueOf).boxed();
    }
}
