import domain.*;


import java.util.List;

import static domain.LottoSeller.*;
import static view.InputView.*;
import static view.ResultView.*;

public class Main {
    public static void main(String[] args) {
        int investMoney = getInvestMoney();
        int numOfManualLotto = getNumOfManualLotto();
        List<List<LottoNo>> nums = getManualNums(numOfManualLotto);

        Lottos lottos = new Lottos(buyLotto(new BuyInfo(investMoney, buyTickets(nums)), new LottoNumCreator()));
        showNumOfBuyLotto(lottos.getNumOfLottos());
        showLottos(lottos);

        WinningLottos winningLottos = lottos.getWinningLottos(getWinningLotto());

        showResult(winningLottos, investMoney);
    }
}
