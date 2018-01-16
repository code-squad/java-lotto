package view;

import domain.Lottos;
import domain.Rank;
import domain.WinningLottos;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Comparator;

public class ResultView {

    private static final String RESULT_PATTERN = "{0} - {1}개";

    public static void printLottos(Lottos lottos) {
        System.out.println(lottos.toString());
    }

    public static void printLottoResults(WinningLottos results) {
        Arrays.stream(Rank.values())
              .filter(r -> !r.isFail())
              .sorted(Comparator.comparingInt(Rank::getWinningMoney))
              .forEach(r -> System.out.println(MessageFormat.format(RESULT_PATTERN,
                                                                    r,
                                                                    results.getCountOfRank(r))));
        printRevenue(results);
    }

    private static void printRevenue(WinningLottos results) {
        System.out.printf("총 수익률은 %.1f 입니다.", results.getRevenue());
    }

    public static void printBuyResult(int manualLottosSize, int randomLottosSize) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", manualLottosSize, randomLottosSize);
    }
}
