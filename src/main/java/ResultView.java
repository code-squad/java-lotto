import java.util.HashMap;

public class ResultView {
    public static void printCount(HashMap<Rank, Integer> finalCount) {
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            System.out.println(rank.getCountOfMatch() + "개 일치 (" + rank.getWinningMoney() + "원)- " + finalCount.get(rank) + "개");
        }
    }
}
