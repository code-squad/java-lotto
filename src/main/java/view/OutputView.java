package view;

import domain.Lotto;
import domain.LottoGame;
import dto.LottoResult;
import dto.UserLotto;

import java.util.List;


import static domain.LottoGame.Rank;
public class OutputView {

    public static void printMyLotto(UserLotto userLotto){
        System.out.println("수동으로 " + userLotto.getManualLottoCount() + "장, 자동으로 " + userLotto.getAutoLottoCount() + "장을 구매했습니다.");
        for (int i = 0; i < userLotto.getTotalCount(); i++) {
            System.out.println(userLotto.getUserLotto().get(i).toString());
        }
    }

    public static void printCountOfWinLotto(LottoResult lottoResult){
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원) - " + lottoResult.getResult().get(Rank.FIFTH));
        System.out.println("4개 일치 (50000원) - " + lottoResult.getResult().get(Rank.FOURTH));
        System.out.println("5개 일치 (1500000원) -  " + lottoResult.getResult().get(Rank.THIRD));
        System.out.println("5개 일치, 보너스볼 일치 (30000000원) -  " + lottoResult.getResult().get(Rank.SECOND));
        System.out.println("6개 일치 (2000000000원) - " + lottoResult.getResult().get(Rank.FIRST));
        System.out.println("당신의 수익률은 " + lottoResult.getRate() + "%입니다.");
    }

    public static void printAmountLotto(int amount) {
        System.out.println(amount + "개 구입하였습니다.");
    }
}
