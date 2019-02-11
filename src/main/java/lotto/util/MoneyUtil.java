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

    public static List<Integer> grade(List<Lotto> lottos, List<Integer> prize, int bonus) {
        List<Integer> gradeList = new ArrayList<>();

        for (int i = 3; i <= 6; i++) {
            int grade = 0;
            for (int j = 0; j < lottos.size(); j++) {
                if (lottos.get(j).matchNum(prize) == Rank.valueOf(i, false).getCountOfMatch()
                        && !lottos.get(j).bonusCheck(prize, bonus)) {
                    grade++;
                }
            }
            gradeList.add(grade);

            if (i == 5) {
                int gradeSecond = 0;
                for (int j = 0; j < lottos.size(); j++) {
                    if (lottos.get(j).bonusCheck(prize, bonus)) {
                        gradeSecond++;
                    }
                }
                gradeList.add(gradeSecond);
            }
        }
        return gradeList;
    }
}