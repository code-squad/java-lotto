import domain.Lotto;
import domain.LottosFactory;
import domain.Statistic;
import util.Parser;

import java.util.List;

import static view.InputView.*;
import static view.ResultView.*;

public class Main {
    static final int PRICE_LOTTO_TICKET = 1000;

    public static void main(String[] args) {
        int purchasePrice = purchasePrice();
        List<Lotto> lottos = LottosFactory.makeLottos(purchasePrice / PRICE_LOTTO_TICKET);
        printLottos(lottos);
        Lotto winnerLotto = new Lotto(Parser.makeWinnerLotto(WinnerLottoNumber()));
        Statistic statistic = new Statistic(lottos);
        printResult(statistic.checkLottoRank(winnerLotto), purchasePrice);
    }
}
