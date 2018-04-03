package domain;

import java.util.HashMap;

public class LottoResult {
    private static final int FOURTH_PRIZE = 5000;
    private static final int THIRD_PRIZE = 50000;
    private static final int SECOND_PRIZE = 1500000;
    private static final int FIRST_PRIZE = 2000000000;
    private static final Double PERCENT = 100.0;

    private HashMap<Rank, Integer> result;
    private Integer rateOfProfit;
    public static LottoResult lottoResult = new LottoResult();

    private LottoResult() {
        result = new HashMap<>();

        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            result.put(rank, 0);
        }
    }

    public static LottoResult getInstance() {
        return lottoResult;
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

    public boolean isValidNumber(int matchedCount) {
        if (matchedCount < 3) {
            return false;
        }
        countPrize(matchedCount);
        return true;
    }

    private boolean countPrize(int matchedCount) {
        if (matchedCount == 3) {
            result.put(Rank.FOURTH, result.get(Rank.FOURTH) + 1);
            return true;
        }
        if (matchedCount == 4) {
            result.put(Rank.THIRD, result.get(Rank.THIRD) + 1);
            return true;
        }
        if (matchedCount == 5) {
            result.put(Rank.SECOND, result.get(Rank.SECOND) + 1);
            return true;
        }
        if (matchedCount == 6) {
            result.put(Rank.FIRST, result.get(Rank.FIRST) + 1);
            return true;
        }
        return false;
    }

    public String printResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n당첨통계\n");
        sb.append("---------\n");
        sb.append("3개 일치 (5000원)-" + result.get(Rank.FOURTH) + "개\n");
        sb.append("4개 일치 (50000원)-" + result.get(Rank.THIRD) + "개\n");
        sb.append("5개 일치 (1500000원)-" + result.get(Rank.SECOND) + "개\n");
        sb.append("6개 일치 (2000000000원)-" + result.get(Rank.FIRST) + "개\n");
        sb.append("총 수익률은 " + rateOfProfit + "%입니다.\n");
        return sb.toString();
    }
}
