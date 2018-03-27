package domain;

import dto.LottoDto;

import java.util.List;

public class WinningLotto extends Lotto {
    public static final int LOTTO_NUM = Lotto.LOTTO_NUM + 1;
    private int bonusNumber;

    public WinningLotto(List<Integer> numbers) {
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
        int matchTryNum = 5;
        if (lottoDto.isBonusMatchPoint(matchTryNum)) {
            lottoDto.setBonusMatch(matchBonus(lottoDto));
        }
        return lottoDto;
    }

    private boolean matchBonus(LottoDto lottoDto) {
        return lottoDto.isContainBonusNumber(bonusNumber);
    }
}
