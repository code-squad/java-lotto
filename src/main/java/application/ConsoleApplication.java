package application;

import domain.*;
import view.InputView;
import view.OutputView;

public class ConsoleApplication {
    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();

        LottoGenerator autoLottoGenerator = new AutoLottoGenerator();
        LottoPurchaseInfo lottoPurchaseInfo = new LottoPurchaseInfo(purchaseAmount, autoLottoGenerator);

        OutputView.printPurchaseLottoSize(lottoPurchaseInfo.toDto().getNumOfLotto());
        OutputView.printPurchaseLottos(lottoPurchaseInfo.toDto());

        String winningLottoNumbers = InputView.inputWinningLottoNumbers();

        LottoGenerator manualLottoGenerator = new ManualLottoGenerator(winningLottoNumbers);
        Lotto winningLotto = manualLottoGenerator.generateLotto();
        Statistics statistics = new Statistics(lottoPurchaseInfo.getLottos(), winningLotto);

        OutputView.printMatchingResult(statistics.toDto());
        OutputView.printTotalRateOfReturn(statistics.toDto().getTotalRateOfReturn());
    }
}
