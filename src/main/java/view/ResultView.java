package view;

import domain.Lotto;
import dto.LottoResult;
import dto.Rank;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ResultView {

    private static final String RESULT_PATTERN = "{0}개 일치 ({1}원) - {2}개";

    private static void printNumberOfPurchase(int numberOfPurchase) {
        System.out.println(String.valueOf(numberOfPurchase) + "개를 구매했습니다");
    }

    public static void printLottos(List<Lotto> lottos) {
        printNumberOfPurchase(lottos.size());
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
    }

    public static void printLottoResults(List<LottoResult> results) {
        Arrays.stream(Rank.values())
              .filter(r -> r != Rank.FAIL)
              .sorted(Comparator.comparingInt(Rank::getWinningMoney))
              .forEach(r -> printLottoResult(r, results));
    }

    private static void printLottoResult(Rank rank, List<LottoResult> results) {
        int count = getCountOfRank(rank, results);
        System.out.println(MessageFormat.format(RESULT_PATTERN, rank.getCountOfMatch(), rank.getWinningMoney(), count));
    }

    private static int getCountOfRank(Rank rank, List<LottoResult> results) {
        return (int) results.stream()
                            .filter(r -> r.getRank() == rank)
                            .count();
    }

    public static void printRevenue(double calculate) {
        System.out.printf("총 수익률은 %.1f 입니다.", calculate);
    }
}
