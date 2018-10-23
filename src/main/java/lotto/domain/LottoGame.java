package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.LottoConstant.LOTTO_PRICE;

public class LottoGame {
    private List<Lotto> lottos = new ArrayList<>();

    public LottoGame(int price) {
        for (int i = 0; i < price/LOTTO_PRICE; i++) {
            lottos.add(Lotto.generateLottoNumber());
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void compare(String input, int bonusNumber){
        WinningNumbers winningNumbers = new WinningNumbers(input, bonusNumber);

        for (Lotto lotto : lottos) {
            int count = winningNumbers.compare(lotto);
            boolean matchBonus = lotto.isContainBonusNumber(bonusNumber);

            GameResult.countMatchLotto(count, matchBonus);
        }
    }
}
