package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.domain.generator.RandomLottoNumberGenerator;
import lotto.view.Input;
import lotto.view.Output;

public class Main {

    public static void main(String[] args) {
        Input input = Input.init(System.in);
        int money = input.getMoney();

        LottoMachine lottoMachine = LottoMachine.init(money);
        Lottos lottos = lottoMachine.generateLottos(new RandomLottoNumberGenerator());
        Output.printLottoCount(lottos.getLottos().size());
        Output.printLottos(lottos.getLottos());

        WinningLotto winningLotto = WinningLotto.generate(input.winNumbers(), input.getBonusBall());
        Output.printResult(lottos.matchResult(winningLotto), money);
    }
}
