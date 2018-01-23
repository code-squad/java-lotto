import lottoGame.domain.Lotto;
import lottoGame.domain.LottoGame;
import lottoGame.domain.WinningLotto;
import lottoGame.util.LottoGenerator;
import lottoGame.view.InputView;
import lottoGame.view.PrintView;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] arg) {
        int invest = InputView.priceInput();
        int lottoNum = LottoGenerator.lottoNum(invest);
        List<Lotto> lottos = new ArrayList<>();
        PrintView.printNum(lottoNum);

        for(int i=0; i<lottoNum; i++) {
            lottos.add(new Lotto(LottoGenerator.makeLotto()));
        }
        LottoGame lottoGame = new LottoGame(invest,lottos);

        PrintView.printLotto(lottoGame.getLottos());

        String lastWeek = InputView.lastWeekNums();
        int bonus = InputView.bonusInput();

        WinningLotto winningLotto = new WinningLotto(LottoGenerator.lastWeekLotto(lastWeek),bonus);

        lottoGame.runGame(winningLotto);

        PrintView.printStatistics(lottoGame);
        PrintView.printResult(lottoGame);
    }
}
