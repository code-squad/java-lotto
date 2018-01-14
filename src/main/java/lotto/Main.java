package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.enums.LottoCorrectCount;
import lotto.dto.LottoResult;
import lotto.util.LottoUtils;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Input input = Input.init(System.in);
        int money = input.getMoney();

        LottoMachine lottoMachine = LottoMachine.init(money);
        List<Lotto> lottos = lottoMachine.generateLottos();
        Output.printLottoCount(lottos.size());
        Output.printLottos(lottos);

        List<LottoResult> lottoResults = LottoMachine.getLottoResults(lottos, input.winNumbers());
        Map<LottoCorrectCount, Integer> resultMap = LottoUtils.resultToMap(lottoResults);
        Output.printResult(resultMap);
        Output.printProfit(resultMap, money);
    }
}
