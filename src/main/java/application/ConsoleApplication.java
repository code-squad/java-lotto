package application;

import domain.*;
import dto.StatisticsDto;
import generator.AutoLottoGenerator;
import generator.IntegratedLottoGenerator;
import generator.LottoGenerator;
import generator.ManualLottoGenerator;
import view.InputView;
import view.OutputView;
import domain.WinningLotto;

import java.util.List;

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

        WinningLotto winningLotto = integratedLottoGenerator.generateWinningLotto(winningLottoNumbers, bonusNumber);
        StatisticsDto statisticsDto = winningLotto.calculateWinningCount(integratedLottoGenerator.getLottos());
        int totalRateOfReturn = money.calculateTotalRateOfReturn(statisticsDto.getRankCount());

        OutputView.printMatchingResult(statisticsDto);
        OutputView.printTotalRateOfReturn(totalRateOfReturn);
    }
}
