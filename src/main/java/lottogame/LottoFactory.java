package lottogame;

import lottogame.util.LottoUtils;
import lottogame.util.MyStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;

/**
 * Created by hongjong-wan on 2018. 4. 7..
 */
public class LottoFactory {

    private static final int LOTTO_CHOOSE_COUNT = 6;

    public static Lotto createAutoLotto() {
        return chooseSixNumber(suffle(createfortyFiveNumbers()));
    }

    public static Lotto createManualLotto(String text) {
        if (StringUtils.isBlank(text)) {
            throw new IllegalArgumentException("공백을 입력하면 안됩니다.");
        }

        Lotto lotto = LottoUtils.createLotto(MyStringUtils.split(text));

        if (lotto.getSize() != LOTTO_CHOOSE_COUNT) {
            throw new IllegalArgumentException("로또는 6개의 숫자를 가져야만 합니다.");
        }
        return lotto;
    }


    public static Lotto createfortyFiveNumbers() {
        Lotto lotto = new Lotto();
        for (int i = 1; i <= 45; i++) {
            lotto.add(new LottoNo(i));
        }
        return lotto;
    }

    public static Lotto suffle(Lotto lotto) {
        Collections.shuffle(lotto.getLottoNos());
        return lotto;
    }

    public static Lotto chooseSixNumber(Lotto lotto) {
        Lotto resultLotto = new Lotto();
        for (int i = 0; i < LOTTO_CHOOSE_COUNT; i++) {
            resultLotto.add(lotto.getLottoNos().get(i));
        }
        return resultLotto;
    }

}