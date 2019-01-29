package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.List;

public class MoneyUtil {
    public static int profitRate(List<Rank> ranks, List<Integer> pageMoney, int purchaseSum) {
        return maxMoney(ranks, pageMoney) / purchaseSum;
    }

    public static int maxMoney(List<Rank> ranks, List<Integer> pageMoney) {
        int maxMoney = 0;
        for (int i = 0; i < ranks.size(); i++) {
            maxMoney += ranks.get(i).getWinningMoney() * pageMoney.get(i);
        }
        return maxMoney;
    }

    public static List<Integer> grade(List<Rank> ranks, List<Lotto> lottos, List<Integer> prize) {
        List<Integer> gradeList = new ArrayList<>();
        for (int i = 0; i < ranks.size(); i++) {
            int grade = onePageCheck(ranks.get(i), lottos, prize);
            gradeList.add(grade);
        }
        return gradeList;
    }

    private static int onePageCheck(Rank ranks, List<Lotto> lottos, List<Integer> prize) {
        int grade = 0;
        for (int j = 0; j < lottos.size(); j++) {
            if (lottos.get(j).matchNum(prize) == ranks.getCountOfMatch()) {
                grade++;
            }
        }
        return grade;
    }
}
