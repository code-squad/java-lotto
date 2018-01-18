import domain.Lotto;
import domain.LottoMachine;
import domain.WinningLotto;
import dto.LottoResult;
import view.InputView;
import view.ResultView;

import java.util.List;

public class Main {

  public static void main(String[] args) {
    LottoMachine lottoMachine = new LottoMachine();

    int money = InputView.inputPurchaseMoney();
    int lottoCount = lottoMachine.getLottoCount(money);
    ResultView.printPurchaseLottoCount(lottoCount);

    List<Lotto> lottos = lottoMachine.issue(lottoCount);
    ResultView.printPurchaseLottos(lottos);

    String strNumbers = InputView.inputWinningNumbers();
    int bonusNumber = InputView.inputBonusNumber();
    WinningLotto winningLotto = LottoMachine.createWinningLotto(strNumbers, bonusNumber);

    LottoResult result = lottoMachine.match(winningLotto);
    ResultView.printResult(result);
  }
}
