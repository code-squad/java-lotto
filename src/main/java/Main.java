import domain.*;
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
            int purchasePrice = inputPurchasePrice();
            Lottos lottos = LottosFactory.makeLottos(purchasePrice / PRICE_OF_LOTTO_TICKET);
            printLottos(lottos);

            Lotto winnerLotto = LottoFactory.makeWinnerLotto(Parser.makeIntegerList(inputWinnerLottoNumber()));
            Statistic statistic = lottos.match(winnerLotto, inputBonus());
            printResult(statistic, purchasePrice);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            start();
        }
    }
}
