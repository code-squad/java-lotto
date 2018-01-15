import lottoGame.domain.LottoGame;
import lottoGame.util.LottoGenerator;
import lottoGame.view.InputView;
import lottoGame.view.PrintView;

import java.util.List;


public class Main {
    public static void main(String[] arg) {
        int invest = InputView.priceInput();
        int lottoNum = LottoGenerator.lottoNum(invest);
        PrintView.printNum(lottoNum);

        LottoGame lottoGame = new LottoGame(invest);

        PrintView.printLotto(lottoGame.getLottos());

        String lastWeek = InputView.lastWeekNums();
        List<Integer> lastWeekNumbers = LottoGenerator.lastWeekLotto(lastWeek);

        lottoGame.runGame(lastWeekNumbers);

        PrintView.printStatistics(lottoGame.getResult());
        PrintView.printResult(lottoGame.getLottos(),invest);
    }
}
