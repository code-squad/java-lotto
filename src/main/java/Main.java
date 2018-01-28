import domain.lotto.InputString;
import domain.lotto.LottoMachine;
import domain.lotto.LottoNumber;
import domain.lotto.Money;
import dto.LottoMoney;
import input.Input;
import out.Out;

public class Main {
    public static void main(String[] args) {

        Input input = new Input();
        Out out = new Out();

        LottoMachine lottoMachine = LottoMachine.of(input.inputMoney());

        out.printBuyConfirmMassage(lottoMachine.getPurchasedLottoTicket());// print ticket.

        out.printResultMassage(lottoMachine.getWinningResult(
                InputString.of(input.inputLastWeekWinningNumber())
                , LottoNumber.of(input.insertBonusball()))
        );// print result.
    }
}
