import customer.Customer;
import model.InputView;
import model.ResultView;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer();

        ResultView.printNumber(customer.buy(InputView.scanMoneyToBuy()).size());
        ResultView.printLottoNumbers(customer.getLottos());

        String lastWeekHitNumbers = InputView.scanLastWeekLottoNumbers();

        ResultView.printResult(customer.countHit(customer.getHitNumbers(lastWeekHitNumbers)));
        ResultView.printStatics(customer.analyze(customer.getHitNumbers(lastWeekHitNumbers)));
    }
}
