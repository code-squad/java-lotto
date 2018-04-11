package lotto;

import java.util.Map;
import java.util.Scanner;

public class ConsoleMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String inputPrice =  inputView.getInputPrice();
        Lotto lotto = new Lotto();
        lotto.buy(inputPrice);
        ResultView resultView = new ResultView();
        resultView.printHavingLotto(lotto);

        String winNumbers = inputView.getWinNumbers();
        Map<Integer, Integer> winResults = lotto.getWinnerMap(winNumbers);
        resultView.printWinResult(lotto.getHavingCount(), winResults);

    }

 }
