package domain;

import enums.LottoPrize;

import java.util.Map;

public class WinningLottos {
    private Map<LottoPrize, Integer> winnerLottos;

    public WinningLottos(Map<LottoPrize, Integer> winnerLottos) {
        this.winnerLottos = winnerLottos;
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
