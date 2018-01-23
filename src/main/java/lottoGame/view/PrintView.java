package lottoGame.view;

import lottoGame.domain.Lotto;
import lottoGame.domain.LottoGame;
import lottoGame.dto.Result;
import lottoGame.enums.Rank;

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

    public static void printStatistics(LottoGame lottoGame) {
        for (Rank rank : Rank.values()) {
            System.out.println(rank.resultString() + lottoGame.getRankCount(rank) + "개");
        }
    }

    public static void printResult(LottoGame lottoGame) {
        System.out.println("총 수익률은 " + lottoGame.calcProfit() + " %입니다");
    }
}
