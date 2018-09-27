package lotto;

import java.util.List;

public class LottoGameMain {
    public static void main(String[] args) {
        while (true) {
            try {
                Money money = InputLottoView.inputMoney();
                int manualPurchaseCount = InputLottoView.inputPurchaseManualLottoCount(money);
                List<String> manualLottoNumbers = InputLottoView.inputPurchaseManualLotto(manualPurchaseCount);
                LottoGame lottoGame = new LottoGame(money, Lotto.makeManualLottoNumbers(manualLottoNumbers));

                OutputLottoView.printNumberOfLottoPurchase(lottoGame);
                OutputLottoView.printPurchaseLotto(lottoGame);

                Lotto winningLottoNumber = Lotto.makeManualLottoNumber(InputLottoView.inputWinnerNumber());
                int bonus = InputLottoView.inputBonus(winningLottoNumber);
                LottoGameResult lottoGameResult = lottoGame.playLottoGame(winningLottoNumber, bonus);
                OutputLottoView.winStat(lottoGameResult, money);

                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}