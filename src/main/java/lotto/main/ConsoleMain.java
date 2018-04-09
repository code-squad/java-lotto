package lotto.main;

import lotto.Lotto;
import lotto.LottoStatistics;
import lotto.LottoStore;
import lotto.view.InputView;

import java.util.List;

public class ConsoleMain {
    public static void main(String[] args) {
        int won = InputView.getWon();

        List<Lotto> lottos = LottoStore.pay(won);
        System.out.println(lottos.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            System.out.println(lotto.numbers);
        }
        System.out.println();

        List<Integer> lucyNumbers = InputView.getLucyNumbers();

        LottoStatistics lottoStatistics = new LottoStatistics(lottos, lucyNumbers);
        System.out.println("당첨 통계");
        System.out.println("-----------------------------");
        System.out.println("3개일치 (5000원) - " + lottoStatistics.result.get(3));
        System.out.println("4개일치 (50000원) - " + lottoStatistics.result.get(4));
        System.out.println("5개일치 (1500000원) - " + lottoStatistics.result.get(5));
        System.out.println("6개일치 (2000000000원) - " + lottoStatistics.result.get(6));
        System.out.println();
        System.out.println("총 수익률은 " + lottoStatistics.rateOfReturn(won) + "%입니다.");
    }
}
