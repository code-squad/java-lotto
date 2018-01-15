package domain;

import enums.LottoPrize;

import java.util.HashMap;
import java.util.Map;

public class WinningLottos {
    private Map<LottoPrize, Integer> winnerLottos;

    public WinningLottos() {
        winnerLottos = new HashMap<>();

        for(LottoPrize prize : LottoPrize.values())
            winnerLottos.put(prize, 0);
    }

    public void addLotto(LottoPrize prize) {
        if(prize == null)
            return;

        winnerLottos.put(prize, winnerLottos.get(prize) + 1);
    }

    public int getNumOfWinnerLottoByPrize(LottoPrize prize) {
        return winnerLottos.get(prize);
    }

    public int getProfit() {
        int sum = 0;

        for(LottoPrize prize : winnerLottos.keySet())
            sum += prize.getTotalPrize(winnerLottos.get(prize));

        return sum;
    }

    public int getProfitPercentage(int investment) {
        return (int) (((double)getProfit() - investment) / investment * 100);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(LottoPrize prize : LottoPrize.values())
            sb.append(prize.getState(winnerLottos.get(prize)));

        return sb.toString();
    }
}
