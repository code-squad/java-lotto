package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author sangsik.kim
 */
public class ResultView {
    private static final String LOTTO_BUY_TEXT = "%d개를 구매했습니다.\n";
    private static final String RESULT_HEAD_TEXT = "당첨 통계\n---------";
    private static final String RESULT_VIEW_TEXT = "%S (%,d원) - %d개\n";
    private static final String PROFIT_RATE_TEXT = "총 수익률은 %d%%입니다.\n";

    public static void printLottos(LottoTicket lottoTickets) {
        System.out.printf(LOTTO_BUY_TEXT, lottoTickets.getQuantity());
        lottoTickets.getLottos()
                .forEach(lotto -> System.out.println(lotto.toString()));
    }

    public static void printResult(LottoResult result) {
        System.out.println(RESULT_HEAD_TEXT);
        Arrays.stream(Rank.values())
                .sorted(Comparator.comparing(Rank::getWinningMoney))
                .forEach(rank -> {
                    if (rank != Rank.MISS) {
                        System.out.printf(RESULT_VIEW_TEXT, rank.getDescription(), rank.getWinningMoney(), result.get(rank));
                    }
                });
        System.out.printf(PROFIT_RATE_TEXT, result.getProfitRate());
    }
}
