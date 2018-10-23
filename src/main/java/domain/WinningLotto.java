package domain;

import vo.LottoNo;

import java.util.Set;

public class WinningLotto extends Lotto {
    private LottoNo bonusBall;

    WinningLotto(Set<LottoNo> numbers, LottoNo bonusBall) {
        super(numbers);
        this.bonusBall = isValidBonusBall(numbers, bonusBall);
    }

    boolean isHitBonusBall(Lotto other){
        return other.isHit(this.bonusBall);
    }

    private LottoNo isValidBonusBall(Set<LottoNo> numbers, LottoNo bonusBall){
        if(numbers.contains(bonusBall)) throw new IllegalArgumentException();
        return bonusBall;
    }
}
