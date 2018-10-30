import controller.LottoGame;
import domain.Lottos;
import domain.WinnerLotto;
import view.ResultView;


public class LottoMain extends IllegalAccessException {
    public static void main(String[] args) {
        int input = LottoGame.inputMoney();

        Lottos userAutoLottos = Lottos.of(LottoGame.autoLottoTry(input).getLottos());
        ResultView.view(userAutoLottos.getLottos());

        WinnerLotto winnerLotto = LottoGame.winnerLottoCreator();
        userAutoLottos.matchLotto(winnerLotto);

        ResultView.winView(userAutoLottos.getLottoryManager(), input);
    }
}
