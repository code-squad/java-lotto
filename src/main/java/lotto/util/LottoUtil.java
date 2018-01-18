package lotto.util;

import lotto.domain.LottoNumber;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoUtil {

    private final static String PARSING_SYMBOL = ",";
    private final static int LOTTO_MIN_NUMBER = 1;
    private final static int LOTTO_MAX_NUMBER = 45;

    public static boolean canLotto(String numbers) {
        String[] split = numbers.split(PARSING_SYMBOL);
        return isBlank(numbers) || numbers.contains(PARSING_SYMBOL) || !isNumeric(split) || !outOfRange(numbers);
    }

    public static boolean canLottoNumber(String number) {
        return isBlank(number) || !isNumeric(number) || !outOfRange(Integer.parseInt(number));
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

    public static int getRandom() {
        return new Random().nextInt(LOTTO_MAX_NUMBER)+LOTTO_MIN_NUMBER;
    }

    private static boolean outOfRange(String numbers) {
        return Stream.of(numbers.split(PARSING_SYMBOL)).mapToInt(Integer::parseInt).anyMatch(number -> outOfRange(number));
    }

    public static boolean canLottoNumber(Integer number) {
        return number == null || outOfRange(number);
    }

    public static boolean outOfRange(Integer number) {
        return number < LOTTO_MIN_NUMBER || LOTTO_MAX_NUMBER < number;
    }
}