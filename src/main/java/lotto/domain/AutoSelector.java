package lotto.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author sangsik.kim
 */
public class AutoSelector {
    private static final int DEFAULT_VALID_LOTTO_SIZE = 6;
    private static final List<LottoNumber> ALL_LOTTO_NUMBERS = IntStream.rangeClosed(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

    public static List<LottoNumber> generate() {
        Collections.shuffle(ALL_LOTTO_NUMBERS);
        return ALL_LOTTO_NUMBERS
                .stream()
                .limit(DEFAULT_VALID_LOTTO_SIZE)
                .sorted(Comparator.comparingInt(LottoNumber::getValue))
                .mapToInt(LottoNumber::getValue)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
