import java.util.HashMap;

public class ResultView {
    public static void printCount(HashMap<Rank, Integer> finalCount) {
        Rank[] ranks = Rank.values();
        for (int i = ranks.length; i > 0; i--) {
            System.out.println(ranks[i-1].getCountOfMatch() + "개 일치 (" + ranks[i-1].getWinningMoney() + "원)- " + finalCount.get(7-i) + "개");
        }
    }
}
