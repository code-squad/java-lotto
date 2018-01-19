package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoNumber.LOTTO_NUMBERS_SIZE;

/**
 * Created by Moonchan on 2018. 1. 16..
 */
public class ManualLottoNumberGenerator implements LottoNumberGenerator{

    private int[] numbers;

    public ManualLottoNumberGenerator(int ... numbers) {
        if(checkValid(numbers)) {
            throw new IllegalArgumentException("로또번호는 " + LOTTO_NUMBERS_SIZE + "개의 숫자로 초기화해야합니다.");
        }
        this.numbers = numbers;
    }

    private boolean checkValid(int[] numbers) {
        return numbers.length != LOTTO_NUMBERS_SIZE;
    }

    @Override
    public List<Integer> generateNumbers() {
        return Arrays.stream(numbers).boxed().collect(Collectors.toList());
    }
}
