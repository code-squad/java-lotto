package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGameResult {
    private Map<Integer, List<Lotto>> winnerLottos;
    private int investment;
    private static final Map<Integer, Integer> prices;
    static {
        prices = new HashMap<>();
        prices.put(3, 5000);
        prices.put(4, 50000);
        prices.put(5, 1500000);
        prices.put(6, 2000000000);
    }

    public LottoGameResult(Map<Integer, List<Lotto>> winnerLottos, int investment) {
        this.winnerLottos = winnerLottos;
        this.investment = investment;
    }

    public int getProfit() {
        int sum = 0;

        for(int correspond : winnerLottos.keySet())
            sum += getSum(correspond, winnerLottos.get(correspond).size());

        return sum;
    }

    public int getProfitPercentage() {
        int sum = getProfit();
        return (int) (((double)sum - investment) / investment * 100);
    }

    private int getSum(int correspond, int size) {
        return prices.get(correspond) * size;
    }
}
