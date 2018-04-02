import domain.Ball;
import domain.LotteryCommission;
import domain.User;
import view.InputView;
import view.ResultView;

import java.util.List;

import static domain.LottoUtils.TICKET_PRICE;

public class Main {

    static User larry;

    private static void buyProcess() {
        try {
            int money = InputView.putUserMoney();
            larry = User.whoHasMoneyOf(money);
            int numTickets = money / TICKET_PRICE;
            int numManual= 0;
            larry.purchaseTicketsAuto(numTickets - numManual);
            ResultView.printLottos(larry);
        } catch (RuntimeException e) {
            buyProcess();
        }
    }

    private static void resultProcess() {
        try {
            List<Integer> winningNumbers = InputView.putWinningLotto();
            Ball bonusBall = InputView.putBonusBall();
            LotteryCommission.selectWinningNumbers(winningNumbers, bonusBall);
            larry.checkTotalResult();
            ResultView.printResult(larry);
        } catch (RuntimeException e) {
            resultProcess();
        }
    }

    public static void main(String[] args) {
        buyProcess();
        resultProcess();
    }

}
