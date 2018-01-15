package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.domain.LottoResults;
import lotto.domain.enums.LottoCorrectCount;
import lotto.dto.LottoResult;

import static java.util.stream.Collectors.groupingBy;
import static lotto.domain.enums.LottoCorrectCount.THREE;

public class LottoUtils {
    public static final int THOUSAND = 1000;
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_MAX_COUNT = 6;
    public static final String REGEX = ", ";

    public static String[] convertIntToString(List<Integer> numbers) {
        return numbers.stream().map(String::valueOf).toArray(String[]::new);
    }

    public static Map<LottoCorrectCount, Integer> resultToMap(LottoResults lottoResults) {
        return lottoResults.getLottoResults().stream()
                .filter(lottoResult -> lottoResult.getCorrectCount() >= THREE.getValue())
                .collect(groupingBy(LottoUtils::makeCorrectKey, Collectors.summingInt(LottoResult::sumCount)));
    }

    private static LottoCorrectCount makeCorrectKey(LottoResult result) {
        return Arrays.stream(LottoCorrectCount.values())
                .filter(lottoCorrectCount -> lottoCorrectCount.isCorrect(result.getCorrectCount()))
                .findFirst().get();
    }
}
