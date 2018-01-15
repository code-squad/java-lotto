package lottoGame.view;

import lottoGame.domain.Lotto;
import lottoGame.dto.Result;

import java.util.List;

public class PrintView {

    public static void printNum(int num) {
        System.out.println(num+ "개를 구매하였습니다");
    }

    public static void printLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static void printStatistics(Result result) {
        System.out.println("3개일치 (5000원) :" + result.profit.get(5000));
        System.out.println("4개일치 (50000원) :" + result.profit.get(50000));
        System.out.println("5개일치 (1500000원) :" + result.profit.get(1500000));
        System.out.println("6개일치 (2000000000원) :" + result.profit.get(2000000000));
    }

    public static void printResult(List<Lotto> lotto, int invest) {
        System.out.println("총 수익률은 " + Result.calcPrice(lotto) + " %입니다");
    }


}
