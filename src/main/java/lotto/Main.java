package lotto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.domain.*;
import lotto.domain.enums.Rank;
import lotto.util.LottoUtils;
import lotto.view.Input;
import lotto.view.Output;

import static lotto.domain.LottoResult.getWinningRank;

public class Main {

    public static void main(String[] args) {
        Input input = Input.init(System.in);
        int money = input.getMoney();

        LottoMachine lottoMachine = LottoMachine.init(money);
        Lottos lottos = lottoMachine.generateLottos();
        Output.printLottoCount(lottos.getLottos().size());
        Output.printLottos(lottos.getLottos());

        List<Integer> winNumbers = input.winNumbers();
        WinningLotto.generate(winNumbers, input.getBonusBall(winNumbers));
        Output.printResult(LottoResult.generate(getWinningRank(lottos)), money);
    }
}
