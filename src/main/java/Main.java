import domain.*;


import static domain.LottoSeller.buyLotto;
import static view.InputView.*;
import static view.ResultView.*;

public class Main {
    public static void main(String[] args) {
        int investMoney = getInvestMoney();

        Lottos lottos = new Lottos(buyLotto(investMoney, new LottoNumCreator()));
        showNumOfBuyLotto(lottos.getNumOfLottos());
        showLottos(lottos);

        WinningLottos winningLottos = lottos.getWinningLottos(getWinningLotto());

        showResult(winningLottos, investMoney);
    }
}
