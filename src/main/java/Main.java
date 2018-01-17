import DTO.WinningResult;
import domain.lotto.LottoMachine;
import input.Input;
import out.Out;

public class Main {
    public static void main(String[] args) {

        LottoMachine lottoMachine = new LottoMachine();
        Input input = new Input();
        Out out = new Out();

        lottoMachine.insertMoney(input.inputMoney()); // insert money.

        lottoMachine.buyLottoTicket();                // buy ticket.
        out.printBuyConfirmMassage(lottoMachine.getPurchasedLottoTicket());// print ticket.

        lottoMachine.inputWinningNumber(input.inputLastWeekWinningNumber());// input winning number.
        WinningResult result = lottoMachine.findMatching();// winning calculate.

        out.printResultMassage(result);// print result.
    }
}
