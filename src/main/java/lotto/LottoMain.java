package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lotto.domain.LottoResult;
import lotto.domain.LottoStore;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.InputUI;
import lotto.view.ResultUI;

public class LottoMain {

    public static void main(String[] args) {
        int amount = InputUI.inputAmount();
        int manualLottoCount = InputUI.inputManualLottoCount();

        List<String> manualLottos = InputUI.inputManualLottoNumbers(manualLottoCount);
        LottoStore lottoStore = new LottoStore(new Money(amount), manualLottos);

        ResultUI.printCount(lottoStore);
        ResultUI.printLottos(lottoStore);

        String winNumbers = InputUI.inputLastWinNumber();
        int bonus = InputUI.inputBonus();
        LottoResult lottoResult = lottoStore.match(new WinningLotto(winNumbers, bonus));
        ResultUI.printStatistics(lottoResult);
        ResultUI.printPercentage(lottoResult);

    }
}
