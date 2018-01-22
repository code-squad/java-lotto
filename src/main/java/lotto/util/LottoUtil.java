package lotto.util;

import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoUtil {

    private final static int LOTTO_MIN_NUMBER = 1;
    private final static int LOTTO_MAX_NUMBER = 45;
    private final static int LOTTO_NUMBER_MAX_COUNT = 6;

    public static int getRandom() {
        return new Random().nextInt(LOTTO_MAX_NUMBER)+LOTTO_MIN_NUMBER;
    }

    public static boolean canLotto(String numbers) {
        numbers = LottoParsingUtil.removeSpace(numbers);
        return LottoParsingUtil.match(numbers) && !outOfRange(numbers) && hasSameNumber(numbers) && isLottoMaxCount(numbers);
    }

    public static boolean canLottoNumber(String number) {
        return !isBlank(number) && isNumeric(number) && !outOfRange(Integer.parseInt(number));
    }

    public static boolean canLottoNumber(Integer number) {
        return number == null || !outOfRange(number);
    }

    public static boolean outOfRange(Integer number) {
        return number < LOTTO_MIN_NUMBER || LOTTO_MAX_NUMBER < number;
    }

    public static boolean isBlank(String numbers) {
        return numbers == null || numbers.isEmpty();
    }

    public static boolean isNumeric(String money) {
        return !isBlank(money) && money.matches("^[0-9]*$");
    }

    private static boolean outOfRange(String numbers) {
        return LottoParsingUtil.stringToIntStream(numbers).anyMatch(number -> outOfRange(number));
    }

    private static boolean hasSameNumber(String numbers) {
        return removeSameNumber(numbers).size() == LottoParsingUtil.stringToIntStream(numbers).count();
    }

    public static boolean isLottoMaxCount(int count) {
        return count == LOTTO_NUMBER_MAX_COUNT;
    }

    private static boolean isLottoMaxCount(String numbers) {
        return isLottoMaxCount((int) LottoParsingUtil.stringToIntStream(numbers).count());
    }

    private static Set<Integer> removeSameNumber(String numbers) {
        return LottoParsingUtil.stringToIntStream(numbers).collect(Collectors.toSet());
    }
}