package lottogame;

import lottogame.domain.Lotto;
import lottogame.domain.LottoGame;
import lottogame.util.LottoRandom;
import lottogame.view.InputView;
import lottogame.view.OutputView;
import lottogame.dto.ResultDTO;

public class LottoGameLoader {
    public static void main(String[] args) {
        int inputMoney = InputView.getMoney();
        LottoGame lottoGame = new LottoGame(inputMoney, new LottoRandom());
        OutputView.printLottoAmount(lottoGame.countLotto());
        OutputView.printLotto(lottoGame.readLotto());
        ResultDTO resultDTO = lottoGame.result(new Lotto(InputView.getWinningNumber()));
        OutputView.printResult(inputMoney, resultDTO);
    }
}
