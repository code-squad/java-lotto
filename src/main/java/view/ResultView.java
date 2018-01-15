package view;

import domain.Lottos;
import domain.WinningLottos;

public class ResultView {

    public static void showLottos(Lottos lottos) {
        System.out.println(lottos.toString());
    }

    public static void showResult(WinningLottos winningLottos, int investment) {
        System.out.println("당첨 통계");
        System.out.println("-----------");
        System.out.println(winningLottos.toString());
        System.out.println("총 수익률은 " + winningLottos.getProfitPercentage(investment) + "%입니다.");
    }

    public static void showNumOfBuyLotto(int size) {
        System.out.println(size + "개를 구매했습니다.");
    }
}
