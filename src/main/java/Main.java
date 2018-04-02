import domain.LotteryCommission;
import domain.LottoNo;
import domain.LottoNoGroup;
import domain.User;
import domain.exceptions.LottoProcessException;
import view.InputView;
import view.ResultView;

import java.io.IOException;
import java.util.List;

import static domain.LottoUtils.TICKET_PRICE;

public class Main {

    static User larry;

    private static void buyProcess() {
        try {
            int money = InputView.enterUserMoney();
            larry = User.whoHasMoneyOf(money);
            int numTickets = money / TICKET_PRICE;
            int numManual = InputView.enterNumManualTickets();
            larry.purchaseTicketsAuto(numTickets - numManual);
            larry.purchaseTicketsManual(InputView.enterNumsOfManualTicket(numManual));
            ResultView.printLottos(larry);
        } catch (LottoProcessException | IOException e) {
            e.printStackTrace();
            buyProcess();
        }
    }

    private static void resultProcess() {
        try {
            LottoNoGroup winningNumbers = InputView.enterWinningLotto();
            LottoNo lottoNo = InputView.enterBonusBall();
            LotteryCommission.selectWinningNumbers(winningNumbers, lottoNo);
            larry.checkTotalResult();
            ResultView.printResult(larry);
        } catch (LottoProcessException e) {
            e.printStackTrace();
            resultProcess();
        }
    }

    public static void main(String[] args) {
        buyProcess();
        resultProcess();
    }

}
