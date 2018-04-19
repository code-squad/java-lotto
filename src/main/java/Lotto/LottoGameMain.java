package Lotto;

import java.util.List;

public class LottoGameMain {
    public static void main(String[] args) {
        int money = InputLottoView.inputMoney();
        LottoGame lottoGame = new LottoGame(money);

        OutputLottoView.printNumberOfLottoPurchase(lottoGame);
        OutputLottoView.printPurchaseLotto(lottoGame);

        List<String> winningNumber = InputLottoView.inputWinnerNumber();
        int bonus = InputLottoView.inputBonus();
        LottoGameResult lottoGameResult = lottoGame.playLottoGame(winningNumber, bonus);
        OutputLottoView.winStat(lottoGameResult, money);
    }
}