package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author sangsik.kim
 */
public class AutoSelector {
    private static final Integer DEFAULT_VALID_LOTTO_SIZE = 6;
    private static final Integer START_NUMBER_INCLUSIVE = 6;
    private static final Integer END_NUMBER_EXCLUSIVE = 43;
    private static final List<Integer> ALL_LOTTO_NUMBERS = IntStream.range(START_NUMBER_INCLUSIVE, END_NUMBER_EXCLUSIVE).boxed().collect(Collectors.toList());

    public static List<Integer> generate() {
        Collections.shuffle(ALL_LOTTO_NUMBERS);
        return ALL_LOTTO_NUMBERS
                .stream()
                .limit(DEFAULT_VALID_LOTTO_SIZE)
                .sorted()
                .collect(Collectors.toList());
    }
}
