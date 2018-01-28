package lotto;

import java.util.List;
import java.util.Map;

/**
 * Created by Joeylee on 2018-01-13.
 */
public class ResultView {

    public static void showPurchaseCount(int selfCount, int autoCount) {
        System.out.println("수동으로 " + selfCount + "장, 자동으로"+autoCount+"개를 구매했습니다.");
    }

    public static void showLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static void showResult(Result result, Money money){

        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(result.toString());
        System.out.println("총 수익률은 "+ money.rateTotal(result.getSum()) +"%입니다.");
    }



}
