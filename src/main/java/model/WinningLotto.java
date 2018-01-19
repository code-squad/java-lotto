package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {

    private LottoNumber bonusNumber;
    private List<LottoNumber> numbers;

    public WinningLotto(List<Integer> numbers, int bonusNumber) throws IllegalArgumentException {
        this.numbers = new ArrayList<>(
                numbers.stream()
                    .map(LottoNumber::new)
                    .collect(Collectors.toList()));
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public ResultTypes compare(UserLotto target) {
        return ResultTypes.findByCode(getMatchCount(target), isBonus(target));
    }

    private int getMatchCount(UserLotto target) {
        int matchCount = 0;
        for (LottoNumber num : this.numbers) {
            if (target.contains(num)) matchCount++;
        }
        return matchCount;
    }

    private boolean isBonus(UserLotto target) {
        return target.contains(bonusNumber);
    }
}
