package lotto.view;

import lotto.domain.LottoGame;
import lotto.domain.LottoGameResult;

public class OutputView {

    private static final String PURCASED_COUNT_FORMAT = "%s개를 구매했습니다.";
    private static final String WIN_STATISTICS_FORMAT = "\n당첨 통계\n---------\n";
    private static final String WIN_FORMAT = "%s개 일치 (%s) - %s개";
    private static final String EARNING_RATE_FORMAT = "총 수익률은 %s%%입니다.";

    public static void printPurchasedLotto(LottoGame lottoGame) {
        System.out.println(String.format(PURCASED_COUNT_FORMAT, lottoGame.getSize()));
        lottoGame.getPurchasedLottos().forEach(lotto -> System.out.println(lotto.getLottos().toString()));
        System.out.println();
    }

    public static void printLottoResult(LottoGameResult lottoGameResult) {
        System.out.println(WIN_STATISTICS_FORMAT);
        lottoGameResult.getLottoGameResult().keySet().forEach(c -> System.out.println(String.format(WIN_FORMAT, c.getMatchCount(), c.getMoney(), lottoGameResult.get(c))));
        System.out.println(String.format(EARNING_RATE_FORMAT, lottoGameResult.getCalculatedEarningRate()));
    }
}
