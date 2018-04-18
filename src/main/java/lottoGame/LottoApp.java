package lottoGame;

import lottoGame.model.*;
import lottoGame.view.InputView;
import lottoGame.view.OutputView;

import java.util.List;

public class LottoApp {

    public static void main(String[] args) {
        LottoApp.start();
    }

    public static void start() {
        int money = InputView.getInputMoney();
        int lottoCnt = Money.getLottoCnt(money);
        List<Lotto> lottoGames = LottoMachine.createLottoGame(lottoCnt);

        printLottoList(lottoGames);
        playLottoGame(lottoGames);
        printResult(money);

    }

    private static void printLottoList(List<Lotto> lottoGames) {
        for(int i = 0; i < lottoGames.size(); i++) {
            OutputView.printLottoNumbers(numberToStrings(lottoGames.get(i).getLottoNumbersToIntArray()));;
        }
    }

    private static void playLottoGame(List<Lotto> lottoGames) {
        LottoNumbers[] winningLottoNums = getWinningLottoValues();

        for(int i = 0; i < lottoGames.size(); i++) {
            Lotto lotto = lottoGames.get(i);
            matchRank(getMatchCnt(lotto,winningLottoNums));
        }
    }

    private static void printResult(int money) {
        OutputView.printLottoGameResult(money);
    }

    private static LottoNumbers[] getWinningLottoValues() {
        Lotto winningLotto = Lotto.ofComma(InputView.getWinningNumberString());
        return winningLotto.getLottoNumbersToArray();
    }

    private static void matchRank(int matchCnt) {
        for(Rank rank : Rank.values()) {
            if(rank.isMatch(matchCnt)) {
                break;
            }
        }
    }

    private static int getMatchCnt(Lotto lotto, LottoNumbers[] winningLottoNums) {
        int matchCnt = 0;
        for(LottoNumbers number : winningLottoNums) {
            if(lotto.isNumberMatch(number))
                matchCnt++;
        }
        return matchCnt;
    }


    private static String[] numberToStrings(int[] numbers) {
        String[] numbersValues = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            numbersValues[i] = Integer.toString(numbers[i]);
        }
        return  numbersValues;
    }

}
