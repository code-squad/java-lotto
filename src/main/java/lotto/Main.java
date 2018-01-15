package lotto;

import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResults;
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
        List<Lotto> lottos = lottoMachine.generateLottos();
        Output.printLottoCount(lottos.size());
        Output.printLottos(lottos);

        Lotto winningLotto = Lotto.generate(new CustomLottoNumberGenerator(input.winNumbers()));
        Map<LottoCorrectCount, Integer> resultMap = LottoUtils.resultToMap(LottoResults.generateLottoResults(lottos, winningLotto));
        Output.printResult(resultMap, money);
    }
}
