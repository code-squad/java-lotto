import dto.LottoResult;
import model.Customer;
import model.Lotto;
import view.InputView;
import view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer();

        List<Lotto> lottos = customer.buy(InputView.scanMoneyToBuy());

        ResultView.printNumber(lottos.size());
        ResultView.printLottoNumbers(lottos);

        String lastWeekHitNumbers = InputView.scanLastWeekLottoNumbers();
        Integer bonus = InputView.scanBonusNumber();

        LottoResult lottoResult = customer.getLottoResult(lastWeekHitNumbers, bonus);

        ResultView.printResult(lottoResult.getLottoResult());
        ResultView.printStatics(lottoResult.analyze(lottos));
    }
}
