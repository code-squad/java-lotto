package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGameResult {
    private static final Map<Integer, Integer> prices;
    private Map<Integer, List<Lotto>> winnerLottos;
    private int investment;

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

    public int getSum(int correspond, int size) {
        return prices.get(correspond) * size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 3 ; i <= 6 ; ++i) {
            sb.append(i).append("개 일치 (").append(prices.get(i)).append("원)- ")
                    .append(winnerLottos.get(i).size()).append("개\n");
        }

        return sb.toString();
    }
}
