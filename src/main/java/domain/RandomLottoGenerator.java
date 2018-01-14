package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static common.Constant.COUNT_OF_LOTTO_NUMBERS;
import static java.util.stream.Collectors.toList;

public class RandomLottoGenerator {

    private final List<LottoNumber> RANGE_OF_NUMBERS = IntStream.range(1, 46)
                                                                .mapToObj(LottoNumber::new)
                                                                .collect(toList());

    public Lotto createRandomLotto() {
        Collections.shuffle(RANGE_OF_NUMBERS, new Random(System.nanoTime()));

        return new Lotto(getSubList());
    }

    private List<LottoNumber> getSubList() {
        return new ArrayList<>(RANGE_OF_NUMBERS.subList(0, COUNT_OF_LOTTO_NUMBERS));
    }

}
