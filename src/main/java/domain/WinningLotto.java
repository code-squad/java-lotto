package domain;

import java.util.List;

public class WinningLotto extends Lotto {
    LottoNo bonus;

    public WinningLotto(List<LottoNo> numbers, LottoNo bonus) {
        super(numbers);
        this.bonus = bonus;
    }

    public boolean hasBonusNo() {
        if (bonus.isEmpty()) {
            return true;
        }
        return false;
    }
}
