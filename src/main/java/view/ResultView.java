package view;

import domain.Lotto;
import domain.Rank;
import dto.LottoResult;
import java.util.Arrays;
import java.util.List;

public class ResultView {

  public static void printPurchaseLottoCount(int count) {
    System.out.println(count + "개를 구매했습니다.");
  }

  public static void printPurchaseLottos(List<Lotto> lottos) {
    lottos.stream().forEach(System.out::println);
  }

  public static void printResult(LottoResult result) {
    System.out.println("당첨 통계");
    System.out.println("------------------------");
    Arrays.stream(Rank.values()).forEach(r -> System.out.println(format(r, result.getRankOfCount(r))));
    System.out.println("총 수익률은 " + result.getFormatToRevenue() + "%입니다.");
  }

  public static String format(Rank rank, int rankOfCount) {
    return String.format("%d개 일치 (%d원) - %d개",
        rank.getMatchOfNumberCnt(), rank.getWinningMoney(), rankOfCount);
  }
}
