package lotto.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoUtils {

    public static List<Integer> createLotto() {
        List<Integer> lotto = createNumber();
        lotto = suffleNumber(lotto);
        lotto = selectSixNumber(lotto);
        return sortNumber(lotto);
    }

    public static List<Integer> createNumber() { //1부터 45까지의 숫자를 List에 담는다.
        List<Integer> fortyFive = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            fortyFive.add(i);
        }
        return fortyFive;
    }

    public static List<Integer> suffleNumber(List<Integer> fortyFive) {
        Collections.shuffle(fortyFive);
        return fortyFive;
    }

    public static List<Integer> selectSixNumber(List<Integer> fortyFive) {
        List<Integer> lotto = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            int lottoNumber = fortyFive.get(i);
            lotto.add(lottoNumber);
        }
        return lotto;
    }

    public static List<Integer> sortNumber(List<Integer> lotto) {
        Collections.sort(lotto);
        return lotto;
    }
}
