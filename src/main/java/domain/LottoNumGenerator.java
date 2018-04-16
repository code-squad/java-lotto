package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumGenerator {
    // 1 ~ 45 숫자를 로또 List에 담기.

    public static List<Integer> createLotto() {
        List<Integer> lotto = createNumber();
        lotto = shuffleNumber(lotto);
        lotto = selectSixNumber(lotto);
        return sortNumber(lotto);
    }

    private static List<Integer> createNumber() {
        List<Integer> lottoNum = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            lottoNum.add(i);
        }
        return lottoNum;
    }

    private static List<Integer> shuffleNumber(List<Integer> lottoNum) {
        Collections.shuffle(lottoNum);
        return lottoNum;
    }

    private static List<Integer> selectSixNumber(List<Integer> lottoNum) {
        List<Integer> lotto = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            int lottoNumber = lottoNum.get(i);
            lotto.add(lottoNumber);
        }
        return lotto;
    }

    private static List<Integer> sortNumber(List<Integer> lotto) {
        Collections.sort(lotto);
        return lotto;
    }
}
