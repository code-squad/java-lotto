package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.WinningTier;

import java.util.Arrays;
import java.util.List;

/**
 * @author sangsik.kim
 */
public class ResultView {

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
    }

    public static void printStatistics(LottoStatistics lottoStatistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        Arrays.stream(WinningTier.values())
                .forEach(tier ->
                System.out.printf("%d개 일치 (%,d원) - %d개\n", tier.getEqualNumbersCount(), tier.getPrizeAmount(), lottoStatistics.count(tier)));
    }
}
