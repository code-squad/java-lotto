package LottoGame.view;

import LottoGame.Lotto;
import LottoGame.Lottos;
import LottoGame.Result;

import java.util.List;

/**
 * Created by hongjong-wan on 2018. 4. 8..
 */
public class ConsoleResultView {

    public static void printPurchaseNumber(int manualLottoCount, int autoLottoCount) {
        System.out.println("수동으로 " + manualLottoCount + "장, 자동으로 " + autoLottoCount + "개를 구매했습니다");
    }

    public static void printLottos(Lottos lottos) {
        List<Lotto> lottoList = lottos.get();
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    public static void printResult(List<Result> results, int yield) {
        printNewLine();
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (Result result : results) {
            System.out.println(result.getRank().getMessage() + result.getCount() + "개");
        }

        System.out.printf("총 수익률은 %d%%입니다.", yield);
    }

    private static void printNewLine() {
        System.out.println();
    }
}