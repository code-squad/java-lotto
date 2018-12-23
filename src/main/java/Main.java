
import domain.Lotto;
import domain.LottoBundle;
import domain.LottoMaker;
import domain.Money;
import dto.ResultDto;
import view.InputView;
import view.ResultView;

public class Main {
    public static void main(String[] args) {
        Money money = new Money(InputView.inputMoney());
        int amount = money.getCount();
        System.out.println(amount + "개를 구매했습니다.");

        LottoBundle lottoBundle = new LottoBundle(LottoMaker.generateLotto(amount));
        ResultView.printLottos(lottoBundle.toDto().getLottos());

        ResultDto resultDto = lottoBundle.checkWin(Lotto.of(InputView.inputWinnerLotto()));
        ResultView.printResult(resultDto.getResult());
        ResultView.printResultRatio(money.calculateRatio(resultDto.getResult()));
    }
}
