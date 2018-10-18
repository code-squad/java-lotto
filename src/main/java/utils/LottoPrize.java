package utils;

import java.util.HashMap;
import java.util.Map;

import static utils.LottoGameValue.*;

public class LottoPrize {
    static Map<Integer, Integer> lottoPrize = new HashMap<>();

    static {
        lottoPrize.put(0, NO_PRIZE);
        lottoPrize.put(1, NO_PRIZE);
        lottoPrize.put(2, NO_PRIZE);
        lottoPrize.put(3, THREE_MATCH_PRIZE);
        lottoPrize.put(4, FOUR_MATCH_PRIZE);
        lottoPrize.put(5, FIVE_MATCH_PRIZE);
        lottoPrize.put(6, SIX_MATCH_PRIZE);
    }

    public static int getLottoPrize(int matchNum) {
        return lottoPrize.get(matchNum);
    }
}
