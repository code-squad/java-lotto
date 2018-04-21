package lotto.domain;

import java.util.stream.Collectors;

public class WinningLotto {

    private Lotto lotto;

    private int bonus;

    public WinningLotto(Lotto lotto, int bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    private int matches(int[] userLotto) {
        return lotto.stream()
                .filter(num -> LottoGame.assertMatch(userLotto, num))
                .collect(Collectors.toList())
                .size();
    }

    private boolean isBonus(int matches) {
        boolean isBonus = false;
        if (matches == 5) {
            isBonus =
                    lotto.stream()
                            .anyMatch(num -> num == bonus);
        }

        return isBonus;
    }

    public Rank matchRank(int[] userLotto) {
        int matches = matches(userLotto);
        return Rank.valueOf(matches, isBonus(matches));
    }

}
