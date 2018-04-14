package lotto.view;

import lotto.domain.GameResult;
import lotto.domain.LottoGame;

public class ResultView implements View {

    public static void printLotto(LottoGame lottoGame) {
        System.out.println("수동으로 " + lottoGame.sizeManualLottos() + "장, 자동으로 " + lottoGame.sizeAutoLottos() + "개를 구매했습니다.");
        System.out.println(lottoGame.toString());
        System.out.println();
    }

    public static void statistic(GameResult gameResult, long amount) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        gameResult.getRank()
                .forEach((key, count) -> System.out.println(key.toString(count)));

        System.out.println("총 수익률은 " + gameResult.rateOfReturn(amount) + "%입니다.");
    }
}
