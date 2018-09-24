package Lotto;

public class LottoGameMain {
    public static void main(String[] args) {
        while (true) {
            try {
                Money money = InputLottoView.inputMoney();
                int manualPurchaseCount = InputLottoView.inputPurchaseManualLottoCount(money);
                LottoGame lottoGame = new LottoGame(money, InputLottoView.inputPurchaseManualLotto(manualPurchaseCount));

                OutputLottoView.printNumberOfLottoPurchase(lottoGame);
                OutputLottoView.printPurchaseLotto(lottoGame);

                Lotto winningLottoNumber = InputLottoView.inputWinnerNumber();
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