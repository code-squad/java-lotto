package lotto;

import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.enums.LottoCorrectCount;
import lotto.domain.generator.CustomLottoNumberGenerator;
import lotto.util.LottoUtils;
import lotto.view.Input;
import lotto.view.Output;

public class Main {

    public static void main(String[] args) {
        Input input = Input.init(System.in);
        int money = input.getMoney();

        LottoMachine lottoMachine = LottoMachine.init(money);
        Lottos lottos = lottoMachine.generateLottos();
        Output.printLottoCount(lottos.getLottos().size());
        Output.printLottos(lottos.getLottos());

        Lotto winningLotto = Lotto.generate(new CustomLottoNumberGenerator(input.winNumbers()));
        Map<LottoCorrectCount, Integer> resultMap = LottoUtils.resultToMap(lottos.match(winningLotto));
        Output.printResult(resultMap, money);
    }
}
