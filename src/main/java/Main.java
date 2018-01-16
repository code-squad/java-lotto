import DTO.LottoResult;
import customer.Customer;
import lotto.Lotto;
import model.InputView;
import model.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer();

        List<Lotto> numberOfLottos = customer.buy(InputView.scanMoneyToBuy());

        ResultView.printNumber(numberOfLottos.size());
        ResultView.printLottoNumbers(numberOfLottos);

        String lastWeekHitNumbers = InputView.scanLastWeekLottoNumbers();

        LottoResult lottoResult = customer.match(lastWeekHitNumbers);

        ResultView.printResult(lottoResult.getCountThreeFourFiveHits());
        ResultView.printStatics(lottoResult.getPercentage());
    }
}
