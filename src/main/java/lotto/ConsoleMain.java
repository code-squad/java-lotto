package lotto;

import java.util.List;

public class ConsoleMain {
    public static void main(String[] args) {
        long buyAmt =  InputView.getInputPrice();

        //수동갯수 입력 받기
        long manualCount = InputView.getManualCount();
        //수동입력 번호 받기
        String[] manualNumbers = InputView.getManualNumbers(manualCount);

        LottoGames lottoGames = new LottoGames(buyAmt, manualNumbers);

        List<String> winNumbers = InputView.getWinNumbers();
        lottoGames.setWinLotto(winNumbers);

        ResultView.printHavingLotto(lottoGames);
        ResultView.printWinResult(buyAmt, lottoGames.getRankMap());

    }

 }
