package lotto;

import org.junit.Test;

import lotto.model.LottoGenerator;
import lotto.model.Lottos;
import lotto.model.Result;
import lotto.model.WinningLotto;
import lotto.view.LottoResultView;

public class LottoGameTest {
    @Test
    public void start() {
        WinningLotto winningLotto = new WinningLotto("5,15,20,31,34,42");
        Lottos lottos = LottoGenerator.generateByMoney(100000000);
        
        Result result = lottos.match(winningLotto);

        LottoResultView.show(result);
    }

}
