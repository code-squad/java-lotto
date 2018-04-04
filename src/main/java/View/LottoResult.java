package View;

import domain.Rank;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private static final int FOURTH_PRIZE = 5000;
    private static final int THIRD_PRIZE = 50000;
    private static final int SECOND_PRIZE = 1500000;
    private static final int FIRST_PRIZE = 2000000000;
    private static final Double PERCENT = 100.0;

    private Map<Rank, Integer> result;
    private Integer rateOfProfit;

    public LottoResult(Map<Rank, Integer> result, int purchaseFee) {
        this.result = result;
        calcRateOfProfit(purchaseFee);
    }

    public void calcRateOfProfit(int purchaseFee) {
        int fourth = FOURTH_PRIZE * result.get(Rank.FOURTH);
        int third = THIRD_PRIZE * result.get(Rank.THIRD);
        int second = SECOND_PRIZE * result.get(Rank.SECOND);
        int first = FIRST_PRIZE * result.get(Rank.FIRST);
        // 1등일 경우 * 100을 먼저할 경우 int 범위를 벗어난다.
        Double result = (fourth + third + second + first) * (PERCENT / purchaseFee);
        rateOfProfit = result.intValue();
    }

    public String printResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n당첨통계\n");
        sb.append("---------\n");
        sb.append("3개 일치 (5000원)-" + result.get(Rank.FIFTH) + "개\n");
        sb.append("4개 일치 (50000원)-" + result.get(Rank.FOURTH) + "개\n");
        sb.append("5개 일치 (1500000원)-" + result.get(Rank.THIRD) + "개\n");
        sb.append("5개 일치, 보너스볼 일치 (30000000원)-" + result.get(Rank.SECOND) + "개\n");
        sb.append("6개 일치 (2000000000원)-" + result.get(Rank.FIRST) + "개\n");
        sb.append("총 수익률은 " + rateOfProfit + "%입니다.\n");
        return sb.toString();
    }
}