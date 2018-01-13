import domain.*;

import java.util.List;

import static domain.LottoChecker.getWinnerLottos;
import static domain.LottoSeller.sellLotto;
import static view.InputView.*;
import static view.ResultView.*;

public class Main {
    public static void main(String[] args) {
        int investMoney = getInvestMoney();

        LottoGame lottoGame = new LottoGame(sellLotto(investMoney, new LottoNumCreator()));
        showNumOfBuyLotto(lottoGame.getLottos().size());
        showLottos(lottoGame);

        List<Integer> winnerNums = getWinnerNums();
        LottoGameResult lottoGameResult = new LottoGameResult(getWinnerLottos(lottoGame.getLottos(), winnerNums), investMoney);

        showResult(lottoGameResult);
    }
}
