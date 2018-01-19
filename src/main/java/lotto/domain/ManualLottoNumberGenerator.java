package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by Moonchan on 2018. 1. 16..
 */
public class ManualLottoNumberGenerator implements LottoNumberGenerator{

    private int[] numbers;

    public ManualLottoNumberGenerator(int ... numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> generateNumbers() {
        return Arrays.stream(numbers).boxed().collect(Collectors.toList());
    }
}
