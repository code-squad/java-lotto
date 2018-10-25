import controller.LottoGame;
import domain.Lotto;
import domain.Lottos;
import view.ResultView;


public class LottoMain extends IllegalAccessException {
    public static void main(String[] args) {
        int input = LottoGame.inputMoney();

        Lottos userAutoLottos = Lottos.of(LottoGame.autoLottoTry(input).getLottos());
        ResultView.view(userAutoLottos.getAutoLottos());


        Lotto winnerLotto = LottoGame.winnerLottoCreator();
        userAutoLottos.matchLotto(winnerLotto);

        System.out.println(winnerLotto);
        ResultView.winView(userAutoLottos.getWinningRules(), input);
    }
}
