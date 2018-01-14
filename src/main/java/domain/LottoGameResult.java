package domain;

import enums.LottoPrize;

import java.util.Map;

public class LottoGameResult {
    private Map<LottoPrize, Integer> winnerLottos;
    private int investment;

    public LottoGameResult(Map<LottoPrize, Integer> winnerLottos, int investment) {
        this.winnerLottos = winnerLottos;
        this.investment = investment;
    }

    public int getProfit() {
        int sum = 0;

        for(LottoPrize prize : winnerLottos.keySet())
            sum += prize.getTotalPrize(winnerLottos.get(prize));

        return sum;
    }

    public int getProfitPercentage() {
        int sum = getProfit();
        return (int) (((double)sum - investment) / investment * 100);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(LottoPrize prize : LottoPrize.values()) {
            sb.append(prize.getNumOfMatch()).append("개 일치")
                    .append(prize.equals(LottoPrize.SECOND) ? ", 보너스 볼 일치 (" : " (")
                    .append(prize.getCashPrize()).append("원)- ")
                    .append(winnerLottos.get(prize)).append("개\n");
        }

        return sb.toString();
    }
}
