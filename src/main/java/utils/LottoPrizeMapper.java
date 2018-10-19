package utils;

import java.util.HashMap;
import java.util.Map;

import static utils.LottoGameValues.*;

public class LottoPrizeMapper {
    static Map<Integer, Integer> lottoPrizeAmount = new HashMap<>();

    static {
        lottoPrizeAmount.put(0, NO_PRIZE);
        lottoPrizeAmount.put(1, NO_PRIZE);
        lottoPrizeAmount.put(2, NO_PRIZE);
        lottoPrizeAmount.put(3, THREE_MATCH_PRIZE);
        lottoPrizeAmount.put(4, FOUR_MATCH_PRIZE);
        lottoPrizeAmount.put(5, FIVE_MATCH_PRIZE);
        lottoPrizeAmount.put(6, SIX_MATCH_PRIZE);
    }

    public static int get(int matchNum) {
        return lottoPrizeAmount.get(matchNum);
    }
}
