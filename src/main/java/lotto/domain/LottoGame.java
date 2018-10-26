package lotto.domain;

import lotto.domain.dto.LottoDto;
import lotto.domain.dto.ResultDto;

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

    public ResultDto compare(String input, int bonusNumber){
        WinningNumbers winningNumbers = new WinningNumbers(input, bonusNumber);
        GameResult result = new GameResult();

        for (Lotto lotto : lottos) {
            int count = winningNumbers.compare(lotto);
            boolean matchBonus = lotto.isContainBonusNumber(bonusNumber);

            result.countMatchLotto(count, matchBonus);
        }
        return result.createResultDto();
    }

    public LottoDto createDto() {
        return new LottoDto(lottos);
    }
}
