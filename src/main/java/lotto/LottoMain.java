package lotto;

import lotto.domain.LottoResult;
import lotto.domain.LottoStore;
import lotto.domain.WinningLotto;
import lotto.view.InputUI;
import lotto.view.ResultUI;

public class LottoMain {

    public static void main(String[] args) {
        int amount = InputUI.inputAmount();
        LottoStore lottoStore = new LottoStore(amount);

        ResultUI.printCount(lottoStore);
        ResultUI.printLottos(lottoStore);

        String winNumbers = InputUI.inputLastWinNumber();
        int bonus = InputUI.inputBonus();
        LottoResult lottoResult = lottoStore.match(new WinningLotto(winNumbers, bonus));
        ResultUI.printStatistics(lottoResult);
        ResultUI.printPercentage(lottoResult);

    }
}
