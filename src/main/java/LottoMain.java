import controller.LottoGame;
import domain.Lotto;
import domain.LottoFactory;
import domain.Rank;
import view.ResultView;


public class LottoMain extends IllegalAccessException {
    public static void main(String[] args) {
        int input = LottoGame.inputMoney();

        LottoFactory lottoFactory = LottoGame.autoLottoTry(input);
        ResultView.view(lottoFactory.getLottos());

        Lotto winnerLotto = LottoGame.winnerLottoCreator();
        Rank ranking = new Rank();
        ranking.matchLotto(lottoFactory.getLottos(), winnerLotto);

        System.out.println(winnerLotto);
        ResultView.winView(ranking, input);
    }
}
