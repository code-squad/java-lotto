import domain.*;
import dto.LottoResult;
import view.InputView;
import view.ResultView;

import java.util.List;
import java.util.stream.IntStream;

public class Main {

  public static void main(String[] args) {

    int money = InputView.inputPurchaseMoney();
    int manualBuyLottoCnt = InputView.inputManualBuyLotto();
    InputView.inputManualLottoNumberText();

    ManualLottoNumberMaker manualLottoNumberMaker = new ManualLottoNumberMaker();
    IntStream.rangeClosed(1, manualBuyLottoCnt).forEach(i -> {
      manualLottoNumberMaker.addManualNumber(InputView.scanner.next());
    });

    LottoMachine lottoMachine = new LottoMachine();
    lottoMachine.setLottoNumberMaker(manualLottoNumberMaker);
    lottoMachine.issue(manualBuyLottoCnt);

    int buyLottoCount = lottoMachine.getLottoCount(money);
    int randomBuyLottoCnt = buyLottoCount - manualBuyLottoCnt;
    List<Lotto> lottos = lottoMachine.issue(randomBuyLottoCnt);
    lottoMachine.setLottoNumberMaker(new RandomLottoNumberMaker());

    ResultView.printPurchaseLottoCount(manualBuyLottoCnt, randomBuyLottoCnt);
    ResultView.printPurchaseLottos(lottos);

    String strNumbers = InputView.inputWinningNumbers();
    int bonusNumber = InputView.inputBonusNumber();
    WinningLotto winningLotto = LottoMachine.createWinningLotto(strNumbers, bonusNumber);

    LottoResult result = lottoMachine.match(winningLotto);
    ResultView.printResult(result);
  }
}
