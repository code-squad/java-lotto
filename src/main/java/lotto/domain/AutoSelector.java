package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.Lotto.LOTTO_SIZE;
import static lotto.domain.LottoNumber.MAX_VALUE;
import static lotto.domain.LottoNumber.MIN_VALUE;

/**
 * @author sangsik.kim
 */
public class AutoSelector {
    private static final List<Integer> ALL_LOTTO_NUMBERS = IntStream
            .rangeClosed(MIN_VALUE, MAX_VALUE)
            .boxed()
            .collect(Collectors.toList());

    public static List<Integer> generate() {
        Collections.shuffle(ALL_LOTTO_NUMBERS);
        return ALL_LOTTO_NUMBERS
                .stream()
                .limit(LOTTO_SIZE)
                .sorted()
                .collect(Collectors.toList());
    }
}
