package lotto;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.LottoGame.getEarnRate;

public class ResultView {

    public static void showAmount(int times) {
        System.out.println(times + "개를 구매했습니다.");
    }

    public static void printSingleLotto(Lotto lotto) {
        final String singleLotto =
                Stream.of(lotto)
                        .flatMap(obj -> obj.getSelectedNumbers().stream())
                        .map(num -> Integer.toString(num))
                        .collect(Collectors.joining(", ", "[", "]"));

        System.out.println(singleLotto);
    }

    public static void showResult(GameResult result, int price) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + result.getMatchThreeCount() + "개");
        System.out.println("4개 일치 (50000원)- " + result.getMatchFourCount() + "개");
        System.out.println("5개 일치 (1500000원)- " + result.getMatchFiveCount() + "개");
        System.out.println("6개 일치 (2000000000원)- " + result.getMatchSixCount() + "개");

        System.out.println("총 수익률은 " + getEarnRate(((double) result.getEarnedMoney()), (double) price) + "%입니다");
    }

}
