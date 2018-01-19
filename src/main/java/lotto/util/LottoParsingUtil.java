package lotto.util;

import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoParsingUtil {
    private final static String PARSING_SYMBOL = ",";
    private final static String LOTTO_PATTERN = "^(\\d{1,2})\\,(\\d{1,2})\\,(\\d{1,2})\\,(\\d{1,2})\\,(\\d{1,2})\\,(\\d{1,2})$";

    public static List<LottoNumber> toLottoNumberList(String numbers) {
        Objects.requireNonNull(numbers);
        return stringToIntStream(numbers)
                .map(number -> new LottoNumber(number))
                .collect(Collectors.toList());
    }

    public static boolean match(String numbers) {
        return numbers.matches(LOTTO_PATTERN);
    }

    public static String removeSpace(String text) {
        if (LottoUtil.isBlank(text)) return text;
        return text.replaceAll("\\s+", "");
    }

    public static Stream<Integer> stringToIntStream(String numbers) {
        return Arrays.asList(removeSpace(numbers).split(PARSING_SYMBOL)).stream().mapToInt(Integer::valueOf).boxed();
    }
}
