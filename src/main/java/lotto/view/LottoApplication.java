package lotto.view;

import lotto.domain.LottoGame;
import lotto.domain.GameResult;
import lotto.domain.Lotto;
import java.util.List;

import static lotto.domain.GenerateLottoNumber.generateRandomNumber;


public class LottoApplication {

    public static void main(String[] args) {

        LottoInput lottoInput = new LottoInput();
        int price = lottoInput.startLotto();
        int times = price / 1000;

        ResultView resultView = new ResultView();
        resultView.showAmount(times);

        List<Lotto> selectedLottos = generateRandomNumber(times);
        resultView.printGeneratedLotto(selectedLottos);

        LottoGame game = new LottoGame(selectedLottos, lottoInput.inputLastWeekNumber(), lottoInput.inputBonus());
        resultView.showResult(game.saveResult(new GameResult()), price);

    }

}
