package lotto.lotto;

import lotto.lotto.domain.BuyingLotto;
import lotto.lotto.domain.Lotto;
import lotto.lotto.domain.WeeklyLotto;
import lotto.lotto.view.Input;
import lotto.lotto.view.View;

import java.util.List;

public class LottoGame {
    public static void main(String[] args) {
        int buyingNum = Input.inputMoney();

        BuyingLotto man = new BuyingLotto(buyingNum);
        List<Lotto> lottos = man.getLottos();
        View.lottoAutomaticView(lottos);

        List<Integer> winningLotto = Input.inputWinningNumber();
        WeeklyLotto week = new WeeklyLotto(winningLotto);
        List<Integer> result = week.confirmRank(lottos);

        View.resultLottoView(result);
    }
}
