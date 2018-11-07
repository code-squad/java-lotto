package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory {
    private static final int FIRST = 0;
    private static final int LAST = 6;

    public static List<Integer> makeRandNumber() {
        List<Integer> randNumber = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            randNumber.add(i);
        }
        Collections.shuffle(randNumber);
        return randNumber;
    }

    public static List<Integer> makeLottoNumber() {
        List<Integer> lottoNumber = makeRandNumber();
        lottoNumber = lottoNumber.subList(FIRST, LAST);
        Collections.sort(lottoNumber);
        return lottoNumber;
    }

    public static Lotto makeRandLotto(){
        return new Lotto(makeLottoNumber());
    }

    public static Lotto makeWinnerLotto(List<Integer> winnerLotto){
        return new Lotto(winnerLotto);
    }
}