package lotto.view;

import lotto.domain.GameResult;
import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void printPurchasedLotto(List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();

        for (Lotto lotto : lottos) {
            List<Integer> purchasedLotto = new ArrayList<Integer>(lotto.getNumbers());
                  sb.append("[")
                    .append(purchasedLotto.stream().map(Object::toString).collect(Collectors.joining(", ")))
                    .append("]").append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void printWinLotto2(GameResult gameResult) {
        StringBuilder sb = new StringBuilder();
        System.out.println("당첨 통계");
        System.out.println("----------");

        Arrays.stream(Rank.values())
              .sorted(Comparator.comparing(Rank::getMoney))
              .forEach(rank -> {
                  if (rank != Rank.NONE) {
                      System.out.printf("%d개 일치 (%d원)- %d개\n", rank.getCountOfMatch(), rank.getMoney(), gameResult.getMatchCount(rank));
                  }
              });
        printRateOfInvestment(gameResult.getRateOfInvestment());
    }

    public static void printRateOfInvestment(double rateOfInvestment) {
        System.out.printf("총 수익률은 %d%%입니다.", (int) rateOfInvestment);
    }
}
