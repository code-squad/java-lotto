import lottoGame.domain.Lotto;
import lottoGame.domain.LottoGame;
import lottoGame.dto.Result;
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
        Lotto lastWeekLotto = LottoGenerator.lastWeekLotto(lastWeek);

        Result result = new Result(lottoGame.runGame(lastWeekLotto));

        PrintView.printStatistics(result);
        PrintView.printResult(lottoGame);
    }
}
