package lottogame;

import lottogame.domain.LottoGame;
import lottogame.domain.WinnningLotto;
import lottogame.dto.ResultDTO;
import lottogame.util.LottoRandom;
import lottogame.view.InputView;
import lottogame.view.OutputView;

public class LottoGameLoader {
    public static void main(String[] args) {
        int inputMoney = InputView.getMoney();
        LottoGame lottoGame = new LottoGame(inputMoney, new LottoRandom());
        OutputView.printLottoAmount(lottoGame.countLotto());
        OutputView.printLotto(lottoGame.readLotto());
        ResultDTO resultDTO = lottoGame.result(
                WinnningLotto.of(InputView.getWinningNumber(), InputView.getBonusNum()));
        OutputView.printResult(inputMoney, resultDTO);
    }
}
