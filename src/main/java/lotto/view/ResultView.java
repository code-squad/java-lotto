package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.Lotto;
import lotto.domain.WinningTier;

import java.util.Arrays;
import java.util.List;

/**
 * @author sangsik.kim
 */
public class ResultView {
    private static final String LOTTO_BUY_TEXT = "%d개를 구매했습니다.";
    private static final String RESULT_HEAD_TEXT = "당첨 통계\n---------";
    private static final String RESULT_VIEW_TEXT = "%d개 일치 (%,d원) - %d개\n";
    private static final String PROFIT_RATE_TEXT = "총 수익률은 %d%%입니다.\n";

    public static void printLottos(List<Lotto> lottos) {
        System.out.printf(LOTTO_BUY_TEXT, lottos.size());
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
    }

    public static void printResult(LottoResult result) {
        System.out.println(RESULT_HEAD_TEXT);
        Arrays.stream(WinningTier.values()).forEach(winningTier -> {
            if (winningTier != WinningTier.FAIL) {
                System.out.printf(RESULT_VIEW_TEXT, winningTier.equalCount(), winningTier.prizeAmount(), result.get(winningTier));
            }
        });

        System.out.printf(PROFIT_RATE_TEXT, result.getProfitRate());
    }
}
