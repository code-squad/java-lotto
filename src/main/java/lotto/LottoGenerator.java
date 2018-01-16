package lotto;

import lotto.domain.LottoConstants;
import lotto.domain.LottoNumber;

import java.util.*;

public class LottoGenerator {
    public static List<LottoNumber> randomNumbers() {
        List<LottoNumber> NUMBERS = new ArrayList<>();
        for (int i = LottoConstants.FIRST_NUMBER; i <= LottoConstants.LAST_NUMBER; i++) {
            NUMBERS.add(LottoNumber.newInstance(i));
        }
        Collections.shuffle(NUMBERS);

        return NUMBERS.subList(LottoConstants.FIRST_NUMBER, LottoConstants.FIRST_NUMBER + LottoConstants.NUMBER_COUNT);
    }
}
