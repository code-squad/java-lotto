package view;

import domain.Lotto;
import domain.Rank;
import dto.LottoResult;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class ResultView {

  public static void printPurchaseLottoCount(int manualBuyLottoCnt, int randomBuyLottoCnt) {
    System.out.printf("수동으로 %d장, 자동으로 %d장을 구매했습니다.", manualBuyLottoCnt, randomBuyLottoCnt);
  }

  public static void printPurchaseLottos(List<Lotto> lottos) {
    lottos.stream().forEach(System.out::println);
  }

  public static void printResult(LottoResult result) {
    System.out.println("당첨 통계");
    System.out.println("------------------------");
    Arrays.stream(Rank.values()).forEach(r -> System.out.println(format(r, result.getRankOfCount(r))));
    System.out.println("총 수익률은 " + formatToRevenue(result.getRevenue()) + "%입니다.");
  }

  public static String format(Rank rank, int rankOfCount) {
    String formatText = rank == Rank.SECOND ? "%d개 일치 보너스볼 일치(%d원) - %d개" : "%d개 일치 (%d원) - %d개";
    return String.format(formatText, rank.getMatchOfNumberCnt(), rank.getWinningMoney(), rankOfCount);
  }

  public static String formatToRevenue(double revenue) {
    return new DecimalFormat("0.##").format(revenue);
  }
}
