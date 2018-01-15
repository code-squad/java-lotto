package lotto;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

public class LottoResult {

    private Set<Integer> winners;
    private LottoStore lottoStore;

    public LottoResult(String result, LottoStore lottoStore) {
        nonNull(result);
        winners = Arrays.stream(result.split(",")).map(i -> Integer.parseInt(i)).collect(Collectors.toSet());
        if (winners.size() != 6) {
            throw new IllegalArgumentException();
        }
        this.lottoStore = lottoStore;
    }

    public Set<Integer> getWinners() {
        return winners;
    }

    public Map<Integer, Integer> getStatistics() {
        Map<Integer, Integer> statistics = new HashMap<>();
        statistics.put(3, 0);
        statistics.put(4, 0);
        statistics.put(5, 0);
        statistics.put(6, 0);

        for (Lotto lotto : lottoStore.getLottos()) {
            int count = lotto.getResult(winners).size();
            if (count > 2) {
                int value = statistics.get(count)+1;
                statistics.put(count, value);
            }
        }
        return statistics;
    }

    public long getPercentage(){
        BigDecimal price =  new BigDecimal(lottoStore.getCount() * 1000);
        BigDecimal earning =  new BigDecimal(getEarnings());
        if (earning.intValue() == 0) {
            return 0;
        }
        return earning.divide(price).longValue();
    }

    private int getEarnings() {
        int earning = 0;
        for (Map.Entry<Integer,Integer> lotto : getStatistics().entrySet()) {
            earning += PriceType.getPriceType(lotto.getKey()).getPrice() * lotto.getValue();
        }
        return earning;
    }
}
