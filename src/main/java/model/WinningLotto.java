package model;

import lombok.Getter;

@Getter
public class WinningLotto {

    private Lotto winningLotto;
    private Integer bonusNum;

    public WinningLotto(Lotto lotto, Integer bonusNum) {
        this.winningLotto = lotto;
        this.bonusNum = bonusNum;
    }

    public Rank compare(Lotto userLotto) {
        Integer hit = userLotto.matchCount(this.winningLotto);
        boolean matchBonus = userLotto.isMatchBonus(bonusNum);
        return Rank.valueOf(hit, matchBonus);
    }
}
