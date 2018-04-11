package javaLotto.view;

import javaLotto.GameResult;
import javaLotto.domain.Grade;
import javaLotto.domain.Lotto;

import java.util.List;

public class ResultView {
    public static void buyLottoInfoPrint(Lotto lottos) {
        lottos.printLottoSize();
        lottos.printLottos();
    }

    public static void resultPrint(GameResult result, int inputPrice) {
        System.out.println("당첨통계");
        System.out.println("3개일치 (5000원) " +result.match(3) + "개");
        System.out.println("4개일치 (50000원) " + result.match(4) + "개");
        System.out.println("5개일치 (1500000원) " + result.match(5) + "개");
        System.out.println("6개일치 (2000000000원) " + result.match(6)+ "개");
        System.out.println("총 수익률은 " + result.returnPercent(inputPrice)+ "% 입니다.");
    }
}
