import domain.*;


import static domain.LottoSeller.sellLotto;
import static view.InputView.*;
import static view.ResultView.*;

public class Main {
    public static void main(String[] args) {
        int investMoney = getInvestMoney();

        LottoGame lottoGame = new LottoGame(sellLotto(investMoney, new LottoNumCreator()));
        showNumOfBuyLotto(lottoGame.getNumOfLottos());
        showLottos(lottoGame);

        LottoGameResult lottoGameResult = new LottoGameResult(lottoGame.matchLottosWithWinnigNums(getWinningLotto()));

        showResult(lottoGameResult, investMoney);
    }
}
