package domain;

import dto.LottoDto;

import java.util.List;

public class WinningLotto extends Lotto {
    public static final int LOTTO_NUM = UserLotto.LOTTO_NUM + 1;
    private static final int BONUS_MATCH_POINT = 5;
    private int bonusNumber;

    WinningLotto(List<Integer> numbers) {
        super(numbers);
    }

    @Override
    void initNumbers(List<Integer> numbers) {
        super.initNumbers(numbers);
        int bonusIdx = numbers.size() - 1;
        bonusNumber = numbers.get(bonusIdx);
    }

    @Override
    public LottoDto match(Lotto lotto) {
        LottoDto lottoDto = super.match(lotto);
        if (lottoDto.isMatchPointOfBonus(BONUS_MATCH_POINT)) {
            lottoDto.setBonusMatch(matchBonus(lotto));
        }
        return lottoDto;
    }

    private boolean matchBonus(Lotto lotto) {
        return lotto.isContainNumber(bonusNumber);
    }
}
