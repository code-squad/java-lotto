package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class MoneyCheck {
    public static long profitRate(List<Rank> ranks, List<Integer> pageMoney, int purchaseSum) {
        return (long) maxMoney(ranks, pageMoney) / purchaseSum;
    }

    private static int maxMoney(List<Rank> ranks, List<Integer> pageMoney) {
        int maxMoney = 0;
        for (int i = 0; i < ranks.size(); i++) {
            maxMoney += ranks.get(i).getWinningMoney() * pageMoney.get(i);
        }
        return maxMoney;
    }

    public static List<Integer> grade(Grade checkGrade) {
        List<Integer> gradeList = new ArrayList<>();
        for (int i = 0; i < getWinnerMoneyList().size(); i++) {
            int grade = 0;

            grade = getManualGrade(checkGrade, i, grade);
            grade = getGrade(checkGrade, i, grade);

            gradeList.add(grade);
        }
        return gradeList;
    }

    private static int getGrade(Grade checkGrade, int i, int grade) {
        for (int j = 0; j < checkGrade.getRandomLotto().size(); j++) {
            if (checkGrade.getRandomLotto().get(j).winnerMoney(checkGrade.getPrize(), checkGrade.getBonus()) == getWinnerMoneyList().get(i)) {
                grade++;
            }
        }
        return grade;
    }

    private static int getManualGrade(Grade checkGrade, int i, int grade) {
        for (int j = 0; j < checkGrade.getManualLotto().size(); j++) {
            if (checkGrade.getManualLotto().get(j).winnerMoney(checkGrade.getPrize(), checkGrade.getBonus()) == getWinnerMoneyList().get(i)) {
                grade++;
            }
        }
        return grade;
    }

    private static List<Integer> getWinnerMoneyList() {
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