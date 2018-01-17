import domain.*;


import static view.InputView.*;
import static view.ResultView.*;

public class Main {
    private static final LottoSeller lottoSeller = new LottoSeller(new LottoNumCreator());

    public static void main(String[] args) {
        BuyInfo buyInfo = getBuyInfo();

        Lottos lottos = lottoSeller.buyLotto(buyInfo);
        showNumOfBoughtLottos(buyInfo);
        showLottos(lottos);

        WinningLottos winningLottos = lottos.getWinningLottos(getWinningLotto());
        showResult(winningLottos, buyInfo);
    }
}
