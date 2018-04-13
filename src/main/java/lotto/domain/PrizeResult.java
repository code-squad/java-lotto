package lotto.domain;

import lotto.Prize;

import java.util.*;

public class PrizeResult {

    public static Map<Prize, Integer> calculatePrizeResult(List<Prize> prizes) {
        Map<Prize, Integer> prizeResult = new LinkedHashMap<>();
        Arrays.stream(Prize.values()).forEach(prize -> prizeResult.put(prize, getCount(prize, prizes)));
        return prizeResult;
    }

    private static int getCount(Prize targetPrize, List<Prize> prizes) {
        return (int)prizes.stream().filter(prize -> prize.equals(targetPrize)).count();
    }
}
