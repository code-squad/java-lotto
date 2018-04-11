package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void printCountOfLotto(int money) {
        System.out.println((money / LottoMachine.LOTTO_PRICE) + "개를 구매했습니다.");
    }

    public static void printPurchasedLotto(List<Integer> purchasedLotto) {
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append("[")
                .append(purchasedLotto.stream().map(Object::toString).collect(Collectors.joining(", ")))
                .append("]").toString());
    }

    public static void printWinLotto(int[] matchCounts) {
        StringBuilder sb = new StringBuilder();
        System.out.println("당첨 통계");
        System.out.println("----------");

        for (int i = LottoMachine.MIN_COUNT_WIN_LOTTO; i <= LottoMachine.COUNT_OF_SELECT_LOTTO; i++) {
            System.out.printf("%d개 일치 (%d원)- %d개\n", i, LottoMachine.winPrice.get(i), matchCounts[i]);
        }
    }

    public static void printRateOfInvestment(double rateOfInvestment) {
        System.out.printf("총 수익률은 %d%%입니다.", (int) rateOfInvestment);
    }
}
