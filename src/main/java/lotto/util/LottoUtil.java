package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.List;

public class LottoUtil {

    public static Lotto parseLotto(List<Integer> numbers) {
        LottoNumber[] numberArr = new LottoNumber[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            numberArr[i] = new LottoNumber(numbers.get(i));
        }
        return new Lotto(numberArr);
    }
}