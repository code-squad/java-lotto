package domain;

import java.util.List;

public class WinningLotto extends Lotto {
    LottoNo bonus;

    public WinningLotto(List<Integer> numbers, Integer bonus) {
        super(numbers);
        this.bonus = new LottoNo(bonus);
    }

    public boolean hasBonusNo() {
        if (bonus.isEmpty()) {
            System.out.println(bonus);
            return true;
        }
        return false;
    }
}
