import DTO.LottoResult;
import model.Customer;
import model.Lotto;
import view.InputView;
import view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer();

        List<Lotto> numberOfLottos = customer.buy(InputView.scanMoneyToBuy());

        ResultView.printNumber(numberOfLottos.size());
        ResultView.printLottoNumbers(numberOfLottos);

        String lastWeekHitNumbers = InputView.scanLastWeekLottoNumbers();
        Integer bonus = InputView.scanBonusNumber();

        LottoResult lottoResult = customer.match(lastWeekHitNumbers, bonus);

        ResultView.printResult(lottoResult.getLottoResult());
        ResultView.printStatics(lottoResult.getPercentage());
    }
}
