import domain.*;

import java.util.List;

import static domain.LottoSeller.sellLotto;
import static view.InputView.*;
import static view.ResultView.*;

public class Main {
    public static void main(String[] args) {
        int investMoney = getInvestMoney();

        LottoGame lottoGame = new LottoGame(sellLotto(investMoney, new LottoNumCreator()));
        showNumOfBuyLotto(lottoGame.getNumOfLottos());
        showLottos(lottoGame);

        List<Integer> winnigNums = getWinnerNums();
        int bonusNum = getBonusNum();
        LottoGameResult lottoGameResult = new LottoGameResult(lottoGame.matchLottosWithWinnigNums(winnigNums, bonusNum), investMoney);

        showResult(lottoGameResult);
    }
}
