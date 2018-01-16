package lotto;

import lotto.domain.LottoResult;
import lotto.domain.LottoStore;
import lotto.view.InputUI;
import lotto.view.ResultUI;

public class LottoMain {

    public static void main(String[] args) {
        InputUI inputUI = new InputUI();
        int amount = inputUI.inputAmount();
        LottoStore lottoStore = new LottoStore(amount);

        ResultUI resultUI = new ResultUI(lottoStore);
        resultUI.printCount();
        resultUI.printLottos();

        String winNumbers = inputUI.inputLastWinNumber();

        resultUI.setLottoResult(new LottoResult(winNumbers, lottoStore));
        resultUI.printStatistics();
        resultUI.printPercentage();
    }
}
