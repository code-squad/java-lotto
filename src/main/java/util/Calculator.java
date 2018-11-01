package util;

import domain.Statistic;
import vo.Prize;

public class Calculator {
    static final int PERCENTAGE = 100;

    public static int calculateProfitRate(Statistic statistic, int purchasePrice) {
        int sum = 0;
        for (Prize prize : Prize.values()) {
            sum += prize.getMoney() * statistic.AccumulatedNumber(prize);
        }
        return sum * PERCENTAGE / purchasePrice;
    }
}
