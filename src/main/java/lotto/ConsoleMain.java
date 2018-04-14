package lotto;

import java.util.List;

public class ConsoleMain {
    public static void main(String[] args) {
        long buyAmt =  InputView.getInputPrice();
        LottoGames lottoGames = new LottoGames(buyAmt);

        List<String> winNumbers = InputView.getWinNumbers();
        lottoGames.setWinnerLotto(winNumbers);

        ResultView.printHavingLotto(lottoGames);
        ResultView.printWinResult(buyAmt, lottoGames.getRankMap());

    }

 }
