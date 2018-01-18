package lotto.domain;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

public class LottoResult {

    private static int LOTTO_PRICE = 1000;

    private List<Lotto> myLottos;

    private WinningLotto winningLottos;

    public LottoResult(List<Lotto> myLottos, WinningLotto winningLottos) {
        this.myLottos = myLottos;
        this.winningLottos = winningLottos;
    }

    public long getPercentage(){
        BigDecimal price =  new BigDecimal(this.myLottos.size() * LOTTO_PRICE);
        BigDecimal earning =  new BigDecimal(getEarnings());
        System.out.println(price +" : " +earning);
        if (earning.intValue() == 0) {
            return 0;
        }
        return earning.divide(price,BigDecimal.ROUND_FLOOR).longValue();
    }

    private int getEarnings() {
        int earning = 0;
        for (Map.Entry<PriceType,Integer> lotto : getResult().entrySet()) {
            earning += lotto.getKey().getPrice() * lotto.getValue();
        }
        return earning;
    }


    public Map<PriceType, Integer> getResult() {
        Map<PriceType, Integer> statistics = new HashMap<>();
        statistics.put(PriceType.FIRST, 0);
        statistics.put(PriceType.SECOND, 0);
        statistics.put(PriceType.THIRD, 0);
        statistics.put(PriceType.FORTH, 0);
        statistics.put(PriceType.FIFTH, 0);

        for (Lotto lotto : myLottos) {
            int count = lotto.getResult(winningLottos.getWinningLottos()).size();
            if (count > 2) {
                PriceType priceType = PriceType.valueOf(count, lotto.hasBonus(winningLottos.getBonus()));
                int value = statistics.get(priceType) +1;
                statistics.put(priceType, value);
            }
        }
        return statistics;
    }
}
