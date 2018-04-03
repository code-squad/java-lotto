package lotto;

import input.InputCommon;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private List<Lotto> lottos;

//    public LottoGame(int inputMoney, List<String> manualNum) {
//        InputCommon input = new InputCommon();
//        lottos = input.makeLottos(inputMoney);
//        lottos = input.addManualLottos(manualNum);
//    }


    public List<Lotto> makeLottos(int inputMoney, List<String> manualNum) {
        InputCommon input = new InputCommon();
        lottos = input.makeLottos(inputMoney);
        return input.addManualLottos(manualNum);
    }


    public List<Lotto> getLottos() {
        return lottos;
    }

}
