package application;

import domain.*;
import view.InputView;
import view.OutputView;

public class ConsoleApplication {
    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();

        AutoLottoGenerator autoLottoGenerator = new AutoLottoGenerator();
        LottoPurchaseInfo lottoPurchaseInfo = new LottoPurchaseInfo(purchaseAmount, autoLottoGenerator);

        OutputView.printPurchaseLottoSize(lottoPurchaseInfo.toDto().getNumOfLotto());
        OutputView.printPurchaseLottos(lottoPurchaseInfo.toDto());

        String winningLottoNumbers = InputView.inputWinningLottoNumbers();

        ManualLottoGenerator manualLottoGenerator = new ManualLottoGenerator(winningLottoNumbers);
        Lotto winningLotto = manualLottoGenerator.generateLotto();
        Analyze analyze = new Analyze(lottoPurchaseInfo.getLottos(), winningLotto);

        OutputView.printMatchingResult(analyze.toDto());
        OutputView.printTotalRateOfReturn(analyze.toDto().getTotalRateOfReturn());
    }
}
