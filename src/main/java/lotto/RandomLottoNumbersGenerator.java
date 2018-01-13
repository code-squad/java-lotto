package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static common.Constant.THE_NUMBER_OF_LOTTO_NUMBERS;
import static java.util.stream.Collectors.toList;

public class RandomLottoNumbersGenerator {

    private final List<LottoNumber> RANGE_OF_NUMBERS = IntStream.range(1, 46)
                                                                .mapToObj(LottoNumber::new)
                                                                .collect(toList());

    public LottoNumbers getRandomLottoNumbers() {
        Collections.shuffle(RANGE_OF_NUMBERS);

        return new LottoNumbers(RANGE_OF_NUMBERS.subList(0, THE_NUMBER_OF_LOTTO_NUMBERS));
    }
}
