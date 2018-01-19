import dto.WinningResult;
import domain.lotto.LottoMachine;
import input.Input;
import out.Out;

public class Main {
    public static void main(String[] args) {

        LottoMachine lottoMachine = new LottoMachine();
        Input input = new Input();
        Out out = new Out();

        lottoMachine.insertMoney(input.inputMoney()); // insert money & buy ticket

        out.printBuyConfirmMassage(lottoMachine.getPurchasedLottoTicket());// print ticket.

        WinningResult result = lottoMachine.getWinningResult(input.inputLastWeekWinningNumber());
        // input lastWeekWinningNumber & winning calculate.

        out.printResultMassage(result);// print result.
    }
}
