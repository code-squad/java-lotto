package lotto.view;

import lotto.domain.LottoGame;
import lotto.domain.GameResult;
import lotto.domain.GenerateLottoNumber;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;


public class LottoApplication {

    public static void main(String[] args) {

        LottoInput lottoInput = new LottoInput();

        int price = lottoInput.startLotto();
        int times = price / 1000;

        ResultView resultView = new ResultView();
        resultView.showAmount(times);

        List<Lotto> selectedLottos = new ArrayList<>();
        GenerateLottoNumber gl = new GenerateLottoNumber();

        ArrayList<Integer> range = gl.getNumberRange();

        for (int i = 0; i < times; i++) {
            Lotto lotto = gl.generateRandomNumber(range);

            if (lotto == null) continue;

            selectedLottos.add(lotto);
        }

        resultView.printGeneratedLotto(selectedLottos);

        String[] inputLastWeekNumber = lottoInput.inputLastWeekNumber();
        int bonus = lottoInput.inputBonus();

        LottoGame game = new LottoGame(selectedLottos, inputLastWeekNumber, bonus);

        resultView.showResult(game.saveResult(new GameResult()), price);

    }

}
