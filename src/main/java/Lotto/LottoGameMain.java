package Lotto;

import java.util.List;

public class LottoGameMain {
    public static void main(String[] args) {
        int money = InputLottoView.inputMoney();
        LottoGame lottoGame = new LottoGame(money);

        OutputLottoView.printNumberOfLottoPurchase(lottoGame);
        OutputLottoView.printPurchaseLotto(lottoGame);

        List<String> winningNumber = InputLottoView.inputWinnerNumber();
        LottoGameResult lottoGameResult = lottoGame.playLottoGame(winningNumber);
        OutputLottoView.winStat(lottoGameResult, money);
    }
}