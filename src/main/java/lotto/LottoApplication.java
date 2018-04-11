package lotto;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        int money = InputView.inputMoney();
        LottoMachine lottoMachine = new LottoMachine();

        int countOfLotto = lottoMachine.getCountOfLotto(money);
        ResultView.printCountOfLotto(money);

        MyLotto lotto = new MyLotto(countOfLotto);
        for (int index = 0; index < countOfLotto; index++) {
            List<Integer> purchasedLotto = lotto.purchaseLotto(index);
            ResultView.printPurchasedLotto(purchasedLotto);
        }

        List<Integer> winLottoNumber = InputView.inputWinNumber();
        int[] matchCount = lottoMachine.getMatchCounts(lotto.getLottos(), winLottoNumber);
        ResultView.printWinLotto(matchCount);
        ResultView.printRateOfInvestment(lottoMachine.getRateOfInvestment(money, matchCount));
    }
}
