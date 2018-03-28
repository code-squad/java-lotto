package view;

import rank.Decision;
import rank.Rank;
import money.Money;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ResultView {
    public static void printCount(HashMap<Rank, Integer> finalCount) {
        Rank[] ranks = Rank.values();
        for(int i = ranks.length - 2; i >= 0; i--)
                    System.out.println(ranks[i].getCountOfMatch() + "개 일치 (" + ranks[i].getWinningMoney() + "원)- " + finalCount.get(ranks[i]) + "개");
    }

    public static void printResult(List<Lotto> lottos, String bonusNum, int inputPrice, Lotto rightNum) {
        Money money = new Money();
        Decision decision = new Decision();
        int profit = money.profit(money.totalMoney(decision.decisionRank(lottos, rightNum, bonusNum)), inputPrice);
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }
}
