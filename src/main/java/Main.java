import domain.LottoSeller;
import domain.Lottos;
import domain.WinningLottos;
import domain.WinningNumbers;
import view.InputView;
import view.ResultView;

import java.util.Optional;

import static view.InputView.getManualLottos;

public class Main {
    public static void main(String[] args) {
        int purchaseAmount = InputView.getPurchaseAmount();

        Optional<Lottos> manualLottos = getManualLottos(purchaseAmount);

        LottoSeller lottoSeller = new LottoSeller();
        Lottos lottos = lottoSeller.buyRandomLottosWithManualLottos(purchaseAmount, manualLottos.orElse(null));

        ResultView.printBuyResult(manualLottos.map(Lottos::size).orElse(0), lottos.size());
        ResultView.printLottos(lottos);

        WinningNumbers winningNumbers = InputView.getWinningNumbers();
        WinningLottos results = lottos.match(winningNumbers);
        ResultView.printLottoResults(results);
    }
}
