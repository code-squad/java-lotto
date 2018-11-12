
import controller.LottoGame;
import domain.Lottos;
import domain.Money;
import domain.WinnerLotto;
import view.ResultView;


public class LottoMain extends IllegalAccessException {
    public static void main(String[] args) {

        Money money = LottoGame.inputMoney();
        //Money money = Money.ofString()
        Lottos userAutoLottos = Lottos.of(LottoGame.inputManualCount(money.count()).getLottos(), money);

        ResultView.view(userAutoLottos.getLottos());
        // 값을 result.html 로 전달
        WinnerLotto winnerLotto = LottoGame.winnerLottoCreator();
        userAutoLottos.matchLotto(winnerLotto);

        ResultView.winView(userAutoLottos.getLottoryManager());
    }

}
