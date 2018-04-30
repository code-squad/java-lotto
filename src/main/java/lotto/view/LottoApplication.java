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

        List<Lotto> manualLottos = null;
        int manualTimes = lottoInput.getManualTimes();
        if (manualTimes > 0)
            manualLottos = lottoInput.getManualLottoNumbers(manualTimes);

        int autoTimes = times - (manualTimes > 0 ? manualTimes : 0);

        ResultView resultView = new ResultView();
        resultView.showAmount(manualTimes, autoTimes);

        List<Lotto> selectedLottos = generateRandomNumber(autoTimes);
        resultView.printGeneratedLotto(manualLottos, selectedLottos);

        if (manualLottos != null)
            selectedLottos.addAll(manualLottos);

        LottoGame game = new LottoGame(selectedLottos, lottoInput.inputLastWeekNumber(), lottoInput.inputBonus());
        resultView.showResult(game.saveResult(new GameResult()), price);

    }

}
