package lotto.view;

import lotto.domain.*;

import java.util.List;
import java.util.Map;

public class ResultView {

    public static void statisticsLottoWinnings(int price){
        GameResult result = new GameResult();
        Map map = result.getResults();

        System.out.println("당첨 통계");
        System.out.println("----------");

        for (Rank rank : Rank.values()) {
            String explain = "";
            if(Rank.SECOND == rank) {
                explain = ", 보너스 볼 일치";
            }
            System.out.println(rank.getCountOfMatch() + "개 일치"
                    + explain + "(" + rank.getWinningMoney() + "원)- "
                    + map.get(rank) + "개");
        }

        double profit = getProfit(map);
        int rateOfReturn = calculateProfits(price, profit);

        System.out.println("총 수익률은 " + rateOfReturn + "% 입니다.");
    }
    private static int calculateProfits(double price, double profit) {
        double result = 0;
        if(profit != 0) {
            result = (profit / price) * 100;
        }
        return (int)result;
    }

    private static double getProfit(Map map) {
        int profit = 0;
        for (Rank rank : Rank.values()) {
            profit += rank.getWinningMoney() * (int)map.get(rank);
        }
        return profit;
    }

    public static void printBuyLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
