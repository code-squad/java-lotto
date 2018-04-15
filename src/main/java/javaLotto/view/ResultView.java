package javaLotto.view;

import javaLotto.domain.GameResult;
import javaLotto.domain.Lotto;
import javaLotto.domain.LottoTicket;
import javaLotto.domain.Statics;

public class ResultView {
    public static void buyLottoInfoPrint(Lotto lottos) {
        lottos.printLottoSize();
        for (LottoTicket ticket : lottos.getLottos()){
             LottoTicket.printTicket(ticket);
          }
    }

    public static void resultPrint(GameResult result, int inputPrice) {
        System.out.println("당첨통계");
        for (Statics info : result.getGrade()) {
            System.out.println(Statics.printMatch(info) + "개 일치 " + "(" + Statics.printMoney(info) + " 원)" + Statics.printCount(info) + "개");
        }
        System.out.println("총 수익률은 " + +result.getPercent(inputPrice) + "%");
    }
}
