package lotto.main;

import lotto.GameResult;
import lotto.Lotto;
import lotto.LottoGame;
import lotto.ResultView;
import lotto.view.InputView;

import java.util.List;
import java.util.stream.Collectors;

public class ConsoleMain {
    public static void main(String[] args) {
        int money = InputView.getWon();
        int buyCount = InputView.getBuyLottoCount();
        List<String> manualLottoNumbers = null;
        if(buyCount > 0) {
            manualLottoNumbers = InputView.getBuyLottoNumber(buyCount);
        }

        List<Lotto> manualLottos = manualLottoNumbers
                .stream()
                .map(Lotto::of)
                .collect(Collectors.toList());

        LottoGame lottoGame = new LottoGame(money, manualLottos);
        ResultView.printLotto(lottoGame);

        List<Integer> winningNumbers = InputView.getLucyNumbers();

        int bonusNumber = InputView.getBonusNumber();

        GameResult result = lottoGame.play(winningNumbers, bonusNumber);
        ResultView.statistic(result, money);
    }
}
