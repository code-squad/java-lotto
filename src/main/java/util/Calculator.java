package util;

import domain.Statistic;
import vo.Prize;

public class Calculator {
    static final long PERCENTAGE = 100;

    public static long calculateProfitRate(Statistic statistic, int purchasePrice) {
        long sum = 0;
        for (Prize prize : Prize.values()) {
            sum += prize.getMoney() * statistic.AccumulatedNumber(prize);
        }
        return sum * PERCENTAGE / purchasePrice;
    }
}
