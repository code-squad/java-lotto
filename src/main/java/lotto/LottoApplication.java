package lotto;

public class LottoApplication {
    public static void main(String[] args) {
        long money = InputView.inputMoney();
        LottoMachine lottoMachine = new LottoMachine(money);

        MyLotto lotto = new MyLotto();
        ResultView.printPurchasedLotto(lotto.purchaseLottos(money));

        LottoNumbers winLottoNumber = InputView.inputWinNumber();
        GameResult gameResult = lottoMachine.calculate(lotto.getLottos(), winLottoNumber);
        ResultView.printWinLotto(gameResult);
    }
}
