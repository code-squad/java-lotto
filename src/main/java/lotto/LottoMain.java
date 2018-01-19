package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lotto.domain.LottoResult;
import lotto.domain.LottoStore;
import lotto.domain.WinningLotto;
import lotto.view.InputUI;
import lotto.view.ResultUI;

public class LottoMain {

    public static void main(String[] args) {
        int amount = InputUI.inputAmount();
        int manualLottoCount = InputUI.inputManualLottoCount();

        Optional<List<String>> manualLottos = Optional.ofNullable(InputUI.inputManualLottoNumbers(manualLottoCount));
        LottoStore lottoStore = new LottoStore(amount, manualLottos.orElse(new ArrayList<>()));

        ResultUI.printCount(lottoStore);
        ResultUI.printLottos(lottoStore);

        String winNumbers = InputUI.inputLastWinNumber();
        int bonus = InputUI.inputBonus();
        LottoResult lottoResult = lottoStore.match(new WinningLotto(winNumbers, bonus));
        ResultUI.printStatistics(lottoResult);
        ResultUI.printPercentage(lottoResult);

    }
}
