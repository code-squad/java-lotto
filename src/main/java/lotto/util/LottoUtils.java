package lotto.util;

import lotto.dto.LottoResult;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static lotto.domain.enums.LottoCorrectCount.*;

public class LottoUtils {
    public static final int THOUSAND = 1000;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_MAX_COUNT = 6;
    public static final String REGEX = ", ";

    public static String[] convertIntToString(int[] numbers) {
        return Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
    }

    public static List<Integer> convertStringToIntList(String[] stringWinNumbers) {
        return Arrays.stream(stringWinNumbers).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }

    public static Map<String, Integer> resultToMap(List<LottoResult> lottoResults) {
        return lottoResults.stream()
                .filter(lottoResult -> lottoResult.getCorrectCount() >= THREE.getValue())
                .collect(groupingBy(LottoUtils::makeCorrectKey, Collectors.summingInt(LottoResult::sumCount)));
    }

    private static String makeCorrectKey(LottoResult result) {
        int count = result.getCorrectCount();

        if (THREE.isCorrect(count)) {
            return THREE.name();
        } else if (FOUR.isCorrect(count)) {
            return FOUR.name();
        } else if (FIVE.isCorrect(count)) {
            return FIVE.name();
        }
        return SIX.name();
    }
}
