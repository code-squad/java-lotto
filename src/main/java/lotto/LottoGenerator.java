package lotto;

import lotto.domain.LottoConstants;

import java.util.*;

public class LottoGenerator {
    public static List<Integer> randomNumbers() {
        List<Integer> NUMBERS = new ArrayList<>();
        for (int i = LottoConstants.FIRST_NUMBER; i <= LottoConstants.LAST_NUMBER; i++) {
            NUMBERS.add(i);
        }
        Collections.shuffle(NUMBERS);

        return NUMBERS.subList(LottoConstants.FIRST_NUMBER, LottoConstants.FIRST_NUMBER + LottoConstants.NUMBER_COUNT);
    }
}
