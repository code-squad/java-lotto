package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {

    private LottoNumber bonusNumber;
    private Lotto lotto;

    public WinningLotto(Lotto lotto, int bonusNumber) throws IllegalArgumentException {
        this.lotto = lotto;
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public ResultTypes compare(Lotto target) {
        return ResultTypes.findByCode(this.lotto.getMatchCount(target), isBonus(target));
    }

    private boolean isBonus(Lotto target) {
        return target.contains(bonusNumber);
    }
}
