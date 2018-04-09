package calculator;

import spark.utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sangsik.kim
 */
public class StringCalculator {
    public static Integer sum(String text) {
        if (StringUtils.isEmpty(text)) {
            return 0;
        }

        List<Integer> numbers = getNumberTokens(text);
        validationHasNegativeNumbers(numbers);

        return sum(numbers);
    }

    private static List<Integer> getNumberTokens(String text) {
        return Arrays.asList(StringUtil.getTextWithoutSeparator(text).split(StringUtil.getSeparator(text)))
                .stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }

    private static void validationHasNegativeNumbers(List<Integer> numbers) {
        numbers.forEach(integer -> {
            if (integer < 0) {
                throw new RuntimeException("Invalid Numbers");
            }
        });
    }

    private static Integer sum(List<Integer> numbers) {
        return numbers
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
