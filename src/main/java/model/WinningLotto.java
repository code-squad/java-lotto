package model;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private int bonusNumber;

    private List<Integer> numbers;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.numbers = new ArrayList<>(numbers);
        this.bonusNumber = bonusNumber;
    }

    public ResultTypes compare(UserLotto target) {
        return ResultTypes.findByCode(getMatchCount(target), isBonus(target));
    }

    private int getMatchCount(UserLotto target) {
        int matchCount = 0;
        for (Integer num : this.numbers) {
            if (target.contains(num)) matchCount++;
        }
        return matchCount;
    }

    private boolean isBonus(UserLotto target) {
        return target.contains(this.bonusNumber);
    }
}
