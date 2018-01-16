package lotto.domain;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

public class LottoResult {

    private static int LOTTO_PRICE = 1000;

    private LottoStore lottoStore;

    public LottoResult(LottoStore lottoStore) {
        this.lottoStore = lottoStore;
    }

    public long getPercentage(){
        BigDecimal price =  new BigDecimal(this.lottoStore.getLottos().size() * LOTTO_PRICE);
        BigDecimal earning =  new BigDecimal(getEarnings());
        if (earning.intValue() == 0) {
            return 0;
        }
        return earning.divide(price).longValue();
    }

    private int getEarnings() {
        int earning = 0;
        for (Map.Entry<PriceType,Integer> lotto : lottoStore.getStatistics().entrySet()) {
            earning += lotto.getKey().getPrice() * lotto.getValue();
        }
        return earning;
    }
}
