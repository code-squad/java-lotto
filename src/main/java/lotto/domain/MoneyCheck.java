package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class MoneyCheck {
    public static long profitRate(List<Rank> ranks, List<Integer> pageMoney, int purchaseSum) {
        return (long) maxMoney(ranks, pageMoney) / purchaseSum * 100;
    }

    private static long maxMoney(List<Rank> ranks, List<Integer> pageMoney) {
        long maxMoney = 0;
        for (int i = 0; i < ranks.size(); i++) {
            maxMoney += (long)ranks.get(i).getWinningMoney() * pageMoney.get(i);
        }
        return maxMoney;
    }

    public static List<Integer> grade(Grade checkGrade) {
        List<Integer> gradeList = new ArrayList<>();
        for (int i = 0; i < getWinnerMoneyList().size(); i++) {
            int grade = 0;

            grade = checkGrade.getManualGrade(getWinnerMoneyList().get(i));
            grade += checkGrade.getGrade(getWinnerMoneyList().get(i));

            gradeList.add(grade);
        }
        return gradeList;
    }

    public static List<Integer> getWinnerMoneyList() {
        List<Integer> winnerMoney = new ArrayList<>();
        for (int i = 3; i <= 6; i++) {
            winnerMoney.add(Rank.valueOf(i, false).getWinningMoney());

            if (i == 5) {
                winnerMoney.add(Rank.valueOf(i, true).getWinningMoney());
            }
        }
        return winnerMoney;
    }
}