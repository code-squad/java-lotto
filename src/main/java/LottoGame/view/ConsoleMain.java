package LottoGame.view;

import LottoGame.LottoGame;
import LottoGame.Lottos;
import LottoGame.WinningLotto;
import LottoGame.Result;

import java.util.List;
import java.util.Scanner;

/**
 * Created by hongjong-wan on 2018. 4. 8..
 */
public class ConsoleMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int money = ConsoleInputView.getMoney(sc);
        LottoGame lottoGame = new LottoGame(money);

        Lottos lottos = lottoGame.getLottos();
        ConsoleResultView.printPurchaseNumber(lottos.get().size());
        ConsoleResultView.printLottos(lottos);

        WinningLotto winningLotto = new WinningLotto(
                ConsoleInputView.getWinningNumber(sc),
                ConsoleInputView.getBonusNumber(sc));
        List<Result> results = lottoGame.getRankResults(winningLotto);
        int yield = lottoGame.getYield(results, money);
        ConsoleResultView.printResult(results, yield);

    }
}