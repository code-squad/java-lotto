import domain.*;


import static domain.LottoSeller.sellLotto;
import static view.InputView.*;
import static view.ResultView.*;

public class Main {
    public static void main(String[] args) {
        int investMoney = getInvestMoney();

        Lottos lottos = new Lottos(sellLotto(investMoney, new LottoNumCreator()));
        showNumOfBuyLotto(lottos.getNumOfLottos());
        showLottos(lottos);

        WinningLottos winningLottos = new WinningLottos(lottos.matchLottosWithWinnigNums(getWinningLotto()));

        showResult(winningLottos, investMoney);
    }
}
