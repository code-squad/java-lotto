package lotto;

import input.InputCommon;
import java.util.List;

public class LottoGame {
    private static List<Lotto> lottos;

    public List<Lotto> makeLottos(int inputMoney, List<String> manualNum) {
        InputCommon input = new InputCommon();
        lottos = input.makeLottos(inputMoney);
        return input.addManualLottos(manualNum);
    }

    public static List<Lotto> getLottos() {
        return lottos;
    }
}
