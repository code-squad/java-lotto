package Lotto;

import java.util.List;

public class LottoGameMain {
    public static void main(String[] args) {
        int money = InputLottoView.inputMoney();
        int manualPurchaseCount = InputLottoView.inputPurchaseManualLottoCount(money);

        LottoGame lottoGame = new LottoGame(money, InputLottoView.inputPurchaseManualLotto(manualPurchaseCount));

        OutputLottoView.printNumberOfLottoPurchase(lottoGame);
        OutputLottoView.printPurchaseLotto(lottoGame);

        List<String> winningNumber = InputLottoView.inputWinnerNumber();
        int bonus = InputLottoView.inputBonus();
        LottoGameResult lottoGameResult = lottoGame.playLottoGame(winningNumber, bonus);
        OutputLottoView.winStat(lottoGameResult, money);
    }
}