package lotto.util;

import lotto.domain.enums.LottoCorrectCount;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class LottoUtils {
    public static final int THOUSAND = 1000;
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_MAX_COUNT = 6;
    public static final String REGEX = ", ";

    public static String[] convertIntToString(List<Integer> numbers) {
        return numbers.stream().map(String::valueOf).toArray(String[]::new);
    }

    public static Map<LottoCorrectCount, Integer> resultToMap(List<LottoCorrectCount> lottoCorrectCounts) {
        return lottoCorrectCounts.stream()
                .collect(groupingBy(Function.identity(), Collectors.summingInt(i->1)));
    }
}
