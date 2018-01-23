package lotto.domain;

import java.math.BigDecimal;
import java.util.*;

public class LottoResult {

    private static int LOTTO_PRICE = 1000;

    private List<Lotto> myLottos;

    private WinningLotto winningLottos;

    private Map<Rank, Integer> resultMap;

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
        for (Map.Entry<Rank,Integer> lotto : resultMap.entrySet()) {
            earning += lotto.getKey().getPrice() * lotto.getValue();
        }
        return earning;
    }


    public Map<Rank, Integer> getResult() {
        for (Lotto lotto : myLottos) {
            Rank lottoResult = winningLottos.getResult(lotto);
            if (lottoResult != null) {
                int value = resultMap.get(lottoResult) + 1;
                resultMap.put(lottoResult, value);
            }
        }
        return resultMap;
    }

    public List<String> getResultList( Map<Rank, Integer> resultMap) {
        List<String> results = new ArrayList<>();
        for (Map.Entry<Rank, Integer> rank : resultMap.entrySet()) {
            results.add(rank.getKey().getCount() +" 일치 " + rank.getKey().getPrice() +" 원 - "+rank.getValue());
        }
        return results;
    }

    private Map<Rank, Integer> initResultMap() {
        Map<Rank, Integer> statistics = new HashMap<>();
        statistics.put(Rank.FIRST, 0);
        statistics.put(Rank.SECOND, 0);
        statistics.put(Rank.THIRD, 0);
        statistics.put(Rank.FORTH, 0);
        statistics.put(Rank.FIFTH, 0);
        return statistics;
    }
}
