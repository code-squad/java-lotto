import domain.Lotto;
import domain.Lottos;
import domain.LottosFactory;
import domain.Statistic;
import util.Parser;

import static view.InputView.*;
import static view.ResultView.*;

public class Main {
    static final int PRICE_OF_LOTTO_TICKET = 1000;

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        try {
            int purchasePrice = purchasePrice();
            Lottos lottos = new Lottos(LottosFactory.makeLottos(purchasePrice / PRICE_OF_LOTTO_TICKET));
            printLottos(lottos);

            Lotto winnerLotto = new Lotto(Parser.makeWinnerLotto(WinnerLottoNumber()));
            Statistic statistic = lottos.match(winnerLotto);
            printResult(statistic, purchasePrice);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            start();
        }
    }
}
