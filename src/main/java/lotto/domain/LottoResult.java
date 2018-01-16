package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import lotto.domain.enums.Rank;

import static java.util.stream.Collectors.groupingBy;

public class LottoResult {
    private Map<Rank, Integer> WinningLottoMap;

    public LottoResult(List<Rank> ranks) {
        WinningLottoMap = resultToMap(ranks);
    }

    public static LottoResult generate(List<Rank> ranks) {
        if(ranks.isEmpty()) throw new IllegalArgumentException();
        return new LottoResult(ranks);
    }

    public static int getProfit(Map<Rank, Integer> resultMap) {
        return resultMap.entrySet().stream()
                .mapToInt(map -> map.getKey().getProfit() * map.getValue())
                .sum();
    }

    public static float getProfitRate(int totalProfit, int money) {
        return (float) totalProfit * 100 / (float) money;
    }

    public static Map<Rank, Integer> resultToMap(List<Rank> ranks) {
        return ranks.stream()
                .collect(groupingBy(Function.identity(), Collectors.summingInt(i->1)));
    }

    public Map<Rank, Integer> getWinningLottoMap() {
        return WinningLottoMap;
    }
}
