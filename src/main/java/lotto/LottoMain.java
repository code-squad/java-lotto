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

        ResultUI.printCount(lottoStore);
        ResultUI.printLottos(lottoStore);

        String winNumbers = inputUI.inputLastWinNumber();
        LottoResult lottoResult = lottoStore.match(winNumbers);
        ResultUI.printStatistics(lottoResult);
        ResultUI.printPercentage(lottoResult);

    }
}
