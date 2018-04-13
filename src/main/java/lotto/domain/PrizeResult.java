package lotto.domain;

import lotto.Prize;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrizeResult {

    public static Map<Prize, Integer> calculatePrizeResult(List<Prize> prizes) {
        Map<Prize, Integer> prizeResult = new HashMap<>();
        Arrays.stream(Prize.values()).forEach(prize -> prizeResult.put(prize, getCount(prize, prizes)));
        return prizeResult;
    }

    private static int getCount(Prize targetPrize, List<Prize> prizes) {
        return (int)prizes.stream().map(prize -> prize.equals(targetPrize)).count();
    }
}
