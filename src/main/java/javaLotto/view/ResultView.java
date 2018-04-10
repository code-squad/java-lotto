package javaLotto.view;

import javaLotto.domain.Grade;
import javaLotto.domain.Lotto;

import java.util.List;

public class ResultView {
    public static void buyLottoInfoPrint(Lotto lottos) {
        System.out.println(lottos.getSize() + "개 구입했습니다.");
        for (List<Integer> lotto : lottos.getLottos()) {
            System.out.println(lotto);
        }
    }

    public static void resultPrint(List<Integer> result, int inputPrice) {
        System.out.println("당첨통계");
        System.out.println("3개일치 (5000원) " + Grade.returnGrade(result, 3) + "개");
        System.out.println("4개일치 (50000원) " + Grade.returnGrade(result, 4) + "개");
        System.out.println("5개일치 (1500000원) " + Grade.returnGrade(result, 5) + "개");
        System.out.println("6개일치 (2000000000원) " + Grade.returnGrade(result, 6) + "개");
        System.out.println("총 수익률은 " + Grade.returnPercent(result, inputPrice) + "% 입니다.");
    }

}
