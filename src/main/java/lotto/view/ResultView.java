package lotto.view;

import lotto.domain.GameResult;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;

import java.util.List;

public class ResultView implements View {

    public static void printLotto(LottoGame lottoGame) {
        final List<Lotto> lottos = lottoGame.getLottos();
        final int size = lottos.size();

        System.out.println(size + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
        System.out.println();
    }

    public static void statistic(GameResult gameResult, long amount) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        gameResult.getRank()
                .forEach((key, value) -> System.out.println(key.matchCount() + "개 일치 (" + key.prizeMoney() + "원)- " + value + "개"));

        System.out.println("총 수익률은 " + gameResult.rateOfReturn(amount) + "%입니다.");
    }
}
