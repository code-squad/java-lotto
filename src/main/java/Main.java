import domain.lotto.LottoMachine;
import input.Input;
import out.Out;

public class Main {
    public static void main(String[] args) {

        Input input = new Input();
        Out out = new Out();

        LottoMachine lottoMachine = new LottoMachine(input.inputMoney(), input.insertBonusball());

        out.printBuyConfirmMassage(lottoMachine.getPurchasedLottoTicket());// print ticket.

        out.printResultMassage(lottoMachine.getWinningResult(input.inputLastWeekWinningNumber()));// print result.
    }
}
