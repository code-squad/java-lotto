package lottoGame.util;

import lottoGame.domain.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_RANGE = 45;
    private static final int LOTTO_PICK_NUM = 6;
    private static final String SPLITER = ",";
    private static List<Integer> lottoNums = new ArrayList<>();

    static {
        for (int i=0; i < LOTTO_RANGE; i++) {
            lottoNums.add(i+1);
        }
    }

    public static List<Integer> makeLotto() {
        Collections.shuffle(lottoNums);
        return new ArrayList<>(lottoNums.subList(0,LOTTO_PICK_NUM));
    }

    public static int lottoNum(int price) {
        if(price < LOTTO_PRICE) {
            throw new IllegalArgumentException();
        }
        return price/LOTTO_PRICE;
    }

    public static Lotto lastWeekLotto(String lastWeek) {
        List<String> lastWeekStrings = Arrays.asList(lastWeek.split(SPLITER));
        List<Integer> lastWeekNums = new ArrayList<>();
        for (String lastWeekString : lastWeekStrings) {
            lastWeekNums.add(Integer.valueOf(lastWeekString));
        }
        return new Lotto(lastWeekNums);
    }

}
