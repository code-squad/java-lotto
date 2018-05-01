package lotto.view;

import lotto.domain.GameResult;
import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoGame.getEarnRate;

public class ResultView {

    public void showAmount(int manualTimes, int autoTimes) {

        StringBuilder builder = new StringBuilder();
        if (manualTimes > 0) {
            builder.append("수동으로 ");
            builder.append(3);
            builder.append("장 ");
        }

        builder.append("자동으로 ");
        builder.append(autoTimes);
        builder.append("개를 구매했습니다.");

        System.out.println(builder.toString());
    }

    public static void printSingleLotto(Lotto lotto) {
        final String singleLotto =
                lotto.stream()
                        .map(num -> Integer.toString(num))
                        .collect(Collectors.joining(", ", "[", "]"));

        System.out.println(singleLotto);
    }

    public void printGeneratedLotto(List<Lotto> manuallyGenLottos, List<Lotto> autoGenLottos) {
        if (manuallyGenLottos != null)
            manuallyGenLottos.stream()
                .forEach(ResultView::printSingleLotto);

        autoGenLottos.stream()
                .forEach(ResultView::printSingleLotto);
    }

    public void showResult(GameResult result, int price) {
        System.out.println("");
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + result.getRankedLotto(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (50000원)- " + result.getRankedLotto(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (1500000원)- " + result.getRankedLotto(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)" + result.getRankedLotto(Rank.SECOND) + "개");
        System.out.println("6개 일치 (2000000000원)- " + result.getRankedLotto(Rank.FIRST) + "개");

        System.out.println("총 수익률은 " + getEarnRate(((double) result.getEarnedMoney()), (double) price) + "%입니다");
    }

}
