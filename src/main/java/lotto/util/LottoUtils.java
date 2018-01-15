package lotto.util;

import java.util.List;

public class LottoUtils {
    public static final int THOUSAND = 1000;
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_MAX_COUNT = 6;
    public static final String REGEX = ", ";

    public static String[] convertIntToString(List<Integer> numbers) {
        return numbers.stream().map(String::valueOf).toArray(String[]::new);
    }

}
