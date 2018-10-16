package lottogame.util;

import lottogame.domain.Lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoRandom implements NumberGenerator{
    private static final int MAXIMUM_LOTTO_NUMBER = 20;
    private static List<Integer> seed = IntStream
                                            .range(1, MAXIMUM_LOTTO_NUMBER)
                                            .boxed()
                                            .collect(Collectors.toList());

    public List<Integer> generate(){
        Collections.shuffle(seed);
        return seed.subList(0, Lotto.CORRECT_LOTTO_NUMBER_AMOUNT);
    }
}
