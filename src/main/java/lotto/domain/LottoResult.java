package lotto.domain;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

public class LottoResult {

    private static int LOTTO_PRICE = 1000;

    private List<Lotto> myLottos;

    private WinningLotto winningLottos;

    private Map<PriceType, Integer> resultMap;

    public LottoResult(List<Lotto> myLottos, WinningLotto winningLottos) {
        this.myLottos = myLottos;
        this.winningLottos = winningLottos;
        this.resultMap = initResultMap();
    }

    public long getPercentage(){
        BigDecimal price =  new BigDecimal(this.myLottos.size() * LOTTO_PRICE);
        BigDecimal earning =  new BigDecimal(getEarnings());
        if (earning.intValue() == 0) {
            return 0;
        }
        return earning.divide(price,BigDecimal.ROUND_FLOOR).longValue();
    }

    private int getEarnings() {
        int earning = 0;
        for (Map.Entry<PriceType,Integer> lotto : resultMap.entrySet()) {
            earning += lotto.getKey().getPrice() * lotto.getValue();
        }
        return earning;
    }


    public Map<PriceType, Integer> getResult() {
        for (Lotto lotto : myLottos) {
            PriceType lottoResult = winningLottos.getResult(lotto);
            if (lottoResult != null) {
                int value = resultMap.get(lottoResult) + 1;
                resultMap.put(lottoResult, value);
            }
        }
        return resultMap;
    }

    private Map<PriceType, Integer> initResultMap() {
        Map<PriceType, Integer> statistics = new HashMap<>();
        statistics.put(PriceType.FIRST, 0);
        statistics.put(PriceType.SECOND, 0);
        statistics.put(PriceType.THIRD, 0);
        statistics.put(PriceType.FORTH, 0);
        statistics.put(PriceType.FIFTH, 0);
        return statistics;
    }
}
