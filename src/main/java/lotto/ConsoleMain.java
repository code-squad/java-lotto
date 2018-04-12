package lotto;

import java.util.Map;

public class ConsoleMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String inputPrice =  inputView.getInputPrice();
        LottoGames lotto = new LottoGames();
        lotto.buy(inputPrice);
        ResultView resultView = new ResultView();
        resultView.printHavingLotto(lotto);

        String winNumbers = inputView.getWinNumbers();
        Map<Integer, Integer> winResults = lotto.getWinnerMap();
        resultView.printWinResult(lotto.getHavingCount(), winResults);

    }

 }
