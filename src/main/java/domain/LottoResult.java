package domain;

import java.util.HashMap;

public class LottoResult {
    private static final int FOURTH_PRIZE = 5000;
    private static final int THIRD_PRIZE = 50000;
    private static final int SECOND_PRIZE = 1500000;
    private static final int FIRST_PRIZE = 2000000000;
    private static final int PERCENT = 100;

    private HashMap<Rank, Integer> result;
    private int rateOfProfit;
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
        rateOfProfit =
                (((FOURTH_PRIZE * result.get(Rank.FOURTH))
                        + (THIRD_PRIZE * result.get(Rank.THIRD))
                        + (SECOND_PRIZE * result.get(Rank.SECOND))
                        + (FIRST_PRIZE * result.get(Rank.FIRST))) * PERCENT) / purchaseFee;
    }

    public boolean isValid(int matchedCount) {
        if (matchedCount < 3) {
            return false;
        }
        if (matchedCount == 3) {
            int value = result.get(Rank.FOURTH);
            value++;
            result.put(Rank.FOURTH, value);
            return true;
        }
        if (matchedCount == 4) {
            int value = result.get(Rank.THIRD);
            value++;
            result.put(Rank.THIRD, value);
            return true;
        }
        if (matchedCount == 5) {
            int value = result.get(Rank.SECOND);
            value++;
            result.put(Rank.SECOND, value);
            return true;
        }
        if (matchedCount == 6) {
            int value = result.get(Rank.FIRST);
            value++;
            result.put(Rank.FIRST, value);
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
