import java.util.ArrayList;
import java.util.HashMap;

public class ResultView {
    public static void printCount(HashMap<Rank, Integer> finalCount) {
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            System.out.println(rank.getCountOfMatch() + "개 일치 (" + rank.getWinningMoney() + "원)- " + finalCount.get(rank) + "개");
        }
    }

    public static void printResult(ArrayList<Lotto> lottos, String bonusNum, int inputPrice) {
        Money money = new Money();
        Decision decision = new Decision();
        Check check = new Check();
        int profit = money.profit(money.totalMoney(decision.decisionRank(lottos, check.right, bonusNum)), inputPrice);
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }
}
