package view;

import domain.LottoGame;
import domain.LottoGameResult;

public class ResultView {

    public static void showLottos(LottoGame lottos) {
        System.out.println(lottos.toString());
    }

    public static void showResult(LottoGameResult lottoGameResult, int investment) {
        System.out.println("당첨 통계");
        System.out.println("-----------");
        System.out.println(lottoGameResult.toString());
        System.out.println("총 수익률은 " + lottoGameResult.getProfitPercentage(investment) + "%입니다.");
    }

    public static void showNumOfBuyLotto(int size) {
        System.out.println(size + "개를 구매했습니다.");
    }
}
