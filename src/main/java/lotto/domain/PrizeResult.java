package lotto.domain;

import com.google.common.collect.Maps;
import lotto.Prize;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PrizeResult {

    private static Map<Prize, Integer> prizeMap = Maps.newEnumMap(Prize.class);

    public static Map<Prize, Integer> calculatePrizeResult(List<Prize> prizes) {
        Arrays.stream(Prize.values()).forEach(prize -> prizeMap.put(prize, getCount(prize, prizes)));
        return prizeMap;
    }

    private static int getCount(Prize targetPrize, List<Prize> prizes) {
        return (int)prizes.stream().map(prize -> prize.equals(targetPrize)).count();
    }

}
