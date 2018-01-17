import domain.LottoGame;
import dto.LottoResult;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class LottoGameMain {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int money = InputView.inputMoney(sc);

        LottoGame lottoGame = new LottoGame(money);
        String luckyNumbers = InputView.inputLuckyNumbers(sc);

        LottoResult result = lottoGame.match(luckyNumbers);
        OutputView.printCountOfWinLotto(result);
    }
}
