package lotto.main;

import lotto.GameResult;
import lotto.LottoGame;
import lotto.ResultView;
import lotto.view.InputView;

import java.util.List;

public class ConsoleMain {
    public static void main(String[] args) {

        int money = InputView.getWon();
        LottoGame lottoGame = new LottoGame(money);
        ResultView.printLotto(lottoGame);

        List<Integer> winningNumber = InputView.getLucyNumbers();
        GameResult result = lottoGame.play(winningNumber);
        ResultView.statistic(result, money);
    }
}
