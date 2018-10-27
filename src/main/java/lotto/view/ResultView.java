package lotto.view;

import lotto.domain.*;
import lotto.dto.LottoDto;
import lotto.dto.ResultDto;

import java.util.Map;

public class ResultView {

    public static void statisticsLottoWinnings(ResultDto result){
        Map map = result.getResults();
        int money = result.getMoney();

        System.out.println("당첨 통계 \n ---------- ");

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
        int rateOfReturn = calculateProfits(money, profit);

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

    public static void printBuyLotto(LottoDto lottos) {
        System.out.println("수동으로 " + (lottos.getLottos().size() - lottos.getNumberOfLottoToBuyManually()) + "장, "
                + "자동으로 " + lottos.getNumberOfLottoToBuyManually()
                + "개를 구매했습니다.");
        System.out.println(lottos.getLottos().size() + "개를 구매했습니다.");

        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto);
        }
    }
}
