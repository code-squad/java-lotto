package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGameResult {
    private List<Lotto> lottos;
    private int investment;
    private static final Map<Integer, Integer> prices;
    static {
        prices = new HashMap<>();
        prices.put(3, 5000);
        prices.put(4, 50000);
        prices.put(5, 1500000);
        prices.put(6, 2000000000);
    }

    public LottoGameResult(List<Lotto> lottos, int investment) {
        this.lottos = lottos;
        this.investment = investment;
    }

    public Map<Integer, List<Lotto>> getResult(List<Integer> winnigNums) {
        Map<Integer, List<Lotto>> resultMap = new HashMap<>();
        for(Lotto lotto : lottos)
            checkWinnigLotto(winnigNums, resultMap, lotto);

        return resultMap;
    }

    private void checkWinnigLotto(List<Integer> winnigNums, Map<Integer, List<Lotto>> resultMap, Lotto lotto) {
        int correspond = lotto.howManyCorrespond(winnigNums);
        if(correspond >= 3)
            putLottoInResultMap(resultMap, lotto, correspond);
    }

    private void putLottoInResultMap(Map<Integer, List<Lotto>> resultMap, Lotto lotto, int correspond) {
        if(!resultMap.containsKey(correspond))
            resultMap.put(correspond, new ArrayList<Lotto>());

        resultMap.get(correspond).add(lotto);
    }

    public int getProfit(List<Integer> winningNums) {
        Map<Integer, List<Lotto>> result = getResult(winningNums);
        int sum = 0;

        for(int correspond : result.keySet())
            sum += getSub(correspond, result.get(correspond).size());

        return sum;
    }

    public int getProfitPercentage(List<Integer> winningNums) {
        int sum = getProfit(winningNums);
        return (sum - investment) / investment * 100;
    }

    private int getSub(int correspond, int size) {
        return prices.get(correspond) * size;
    }
}
