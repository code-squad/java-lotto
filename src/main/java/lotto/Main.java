package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.dto.LottoResult;
import lotto.util.LottoUtils;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Input input = Input.init(System.in);

        LottoMachine lottoMachine = LottoMachine.init(input.getMoney());
        List<Lotto> lottos = lottoMachine.generateLottos();
        Output.printLottoCount(lottos.size());
        Output.printLottos(lottos);

        List<LottoResult> lottoResults = LottoMachine.getLottoResults(lottos, input.winNumbers());
        Output.printResult(LottoUtils.resultToMap(lottoResults));
    }
}
