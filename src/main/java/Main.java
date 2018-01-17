import domain.*;


import static view.InputView.*;
import static view.ResultView.*;

public class Main {
    private static final LottoSeller lottoSeller = new LottoSeller(new LottoNumCreator());

    public static void main(String[] args) {
        int investMoney = getInvestMoney();

        Lottos lottos = new Lottos(lottoSeller.buyLotto(investMoney));
        showNumOfBuyLotto(lottos.getNumOfLottos());
        showLottos(lottos);

        WinningLottos winningLottos = lottos.getWinningLottos(getWinningLotto());

        showResult(winningLottos, investMoney);
    }
}
