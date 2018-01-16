import domain.Lotto;
import domain.LottoMachine;
import dto.LottoResult;
import java.util.List;
import view.InputView;
import view.ResultView;

public class Main {

  public static void main(String[] args) {
    LottoMachine lottoMachine = new LottoMachine();

    int money = InputView.inputPurchaseMoney();
    int lottoCount = lottoMachine.getLottoCount(money);
    ResultView.printPurchaseLottoCount(lottoCount);

    List<Lotto> lottos = lottoMachine.issue(lottoCount);
    ResultView.printPurchaseLottos(lottos);

    String strNumbers = InputView.inputWinningNumbers();
    Lotto winningLotto = LottoMachine.createWinningLotto(strNumbers);

    LottoResult result = lottoMachine.match(winningLotto);
    ResultView.printResult(result);
  }
}
