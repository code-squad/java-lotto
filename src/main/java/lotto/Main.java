package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.view.Input;
import lotto.view.Output;

public class Main {

    public static void main(String[] args) {
        Input input = Input.init(System.in);
        int money = input.getMoney();
        int customCount = input.customLottoCount();

        LottoMachine lottoMachine = LottoMachine.init(money, customCount);
        Lottos lottos = lottoMachine.generateLottos(input.customLottoms(customCount));
        Output.printLottoCount(lottoMachine);
        Output.printLottos(lottos.getLottos());

        Lotto winningOriginalLotto = input.winNumbers();
        WinningLotto winningLotto = WinningLotto.generate(winningOriginalLotto, input.getBonusBall(winningOriginalLotto));
        Output.printResult(lottos.matchResult(winningLotto), money);
    }
}
