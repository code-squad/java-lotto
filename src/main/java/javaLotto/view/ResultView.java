package javaLotto.view;

import javaLotto.domain.GameResult;
import javaLotto.domain.Lotto;
import javaLotto.domain.Statics;

public class ResultView {
    public static void buyLottoInfoPrint(Lotto lottos) {
        lottos.printLottoSize();
        lottos.printLottos();
    }

    public static void resultPrint(GameResult result, int inputPrice) {
        System.out.println("당첨통계");
        for (Statics info : result.getGrade()) {
            System.out.println(info.getGrade() + "개 일치 " + "(" + info.getPrizeMoney() + " 원)" + info.getCount() + "개");

        }
        System.out.println("총 수익률은 " + +result.getPercent(inputPrice) + "%");
    }
}
