package view;

import domain.Lottos;
import domain.Statistic;
import util.Calculator;
import vo.Prize;

public class ResultView {
    public static void printLottos(Lottos lottos) {
        System.out.println(lottos.getSize() + "개를 구매했습니다.");
        for (int i = 0; i < lottos.getSize(); i++) {
            System.out.println(lottos.getLotto(i).toString());
        }
    }

    public static void printResult(Statistic statistic, int purchasePrice) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Prize prize : Prize.values()) {
            System.out.println(prize.getNumber() + "개 일치 (" + prize.getMoney() + "원)-" + statistic.AccumulatedNumber(prize) + "개");
        }
        System.out.println("총 수익률은 " + Calculator.calculateProfitRate(statistic, purchasePrice) + "%입니다");
    }
}
