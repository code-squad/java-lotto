package domain;

import java.util.Set;

public class WinningLotto extends Lotto {
    private int bonusBall;

    WinningLotto(Set<Integer> numbers, int bonusBall) {
        super(numbers);
        isValidBoundary(bonusBall);
        this.bonusBall = bonusBall;
    }

    public boolean isHitBonusBall(Lotto other){
        return other.isHit(this.bonusBall);
    }
}
