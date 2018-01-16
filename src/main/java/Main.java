import domain.LottoSeller;
import domain.Lottos;
import domain.WinningLottos;
import domain.WinningNumbers;
import view.InputView;
import view.ResultView;

import java.util.Optional;

import static common.Constant.LOTTO_PRICE;
import static view.InputView.getManualLottos;

public class Main {
    public static void main(String[] args) {
        int purchaseAmount = InputView.getPurchaseAmount();

        Optional<Lottos> manualLottos = getManualLottos(purchaseAmount);
        int remainedAmount = getRemainedAmount(purchaseAmount, manualLottos.map(Lottos::size).orElse(0));

        LottoSeller lottoSeller = new LottoSeller();
        Optional<Lottos> randomLottos = lottoSeller.buyRandomNumberLottos(remainedAmount);

        ResultView.printBuyResult(manualLottos.map(Lottos::size).orElse(0), randomLottos.map(Lottos::size).orElse(0));

        Lottos userLottos = new Lottos(manualLottos.orElse(null), randomLottos.orElse(null));
        ResultView.printLottos(userLottos);

        WinningNumbers winningNumbers = InputView.getWinningNumbers();
        WinningLottos results = userLottos.match(winningNumbers);
        ResultView.printLottoResults(results);
    }

    private static int getRemainedAmount(int purchaseAmount, int manualLottosSize) {
        return purchaseAmount - manualLottosSize * LOTTO_PRICE;
    }
}
