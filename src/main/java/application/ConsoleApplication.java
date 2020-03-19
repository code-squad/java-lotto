package application;

import domain.*;
import dto.LottosResult;
import generator.AutoLottoGenerator;
import generator.IntegratedLottoGenerator;
import generator.LottoGenerator;
import generator.ManualLottoGenerator;
import view.InputView;
import view.OutputView;
import domain.WinningLotto;
import vo.Rank;

import java.util.List;
import java.util.Map;

public class ConsoleApplication {
    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();
        Money money = new Money(purchaseAmount);

        int numOfManualLottoPurchase = InputView.inputNumOfManualLottoPurchase();
        Purchase purchase = new Purchase(money, numOfManualLottoPurchase);

        List<String> manualLotto = InputView.inputManualLotto(numOfManualLottoPurchase);

        LottoGenerator manualLottoGenerator = new ManualLottoGenerator(manualLotto);
        LottoGenerator autoLottoGenerator = new AutoLottoGenerator(purchase.getAutoSize());
        IntegratedLottoGenerator integratedLottoGenerator =
                new IntegratedLottoGenerator(manualLottoGenerator.generateLotto(), autoLottoGenerator.generateLotto());

        OutputView.printPurchaseLottoSize(purchase.toDto().getManualLottoSize(), purchase.toDto().getAutoLottoSize());
        OutputView.printPurchaseLottos(integratedLottoGenerator.toDto().getLottos());

        String winningLottoNumbers = InputView.inputWinningLottoNumbers();
        int bonusNumber = InputView.inputBonusNumber();

        WinningLotto winningLotto = LottoGenerator.generateWinningLotto(winningLottoNumbers, bonusNumber);
        Map<Rank, Integer> rankCount = winningLotto.calculateWinningCount(integratedLottoGenerator.getLottos());
        double totalRateOfReturn = money.calculateTotalRateOfReturn(rankCount);
        LottosResult lottosResult = new LottosResult(rankCount, totalRateOfReturn);

        OutputView.printMatchingResult(lottosResult.getRankCount());
        OutputView.printTotalRateOfReturn(lottosResult.getTotalRateOfReturn());
    }
}
