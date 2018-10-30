package domain;

import domain.vo.LottoNum;

import java.util.List;

public class WinnerLotto extends AbstractLotto{
    private LottoNum bonus;

    private WinnerLotto(List<LottoNum> nums,int bonus) {
        super(nums);
        this.bonus = setBonus(bonus);
    }

    public static WinnerLotto of(List<String> nums , int bonus) {
        return new WinnerLotto(createLotto(nums),bonus);
    }

    boolean compareBonus(Lotto lotto) {
        return lotto.getLotto().contains(bonus);
    }

    private LottoNum setBonus(int num) {
        if (getLotto().contains(LottoNum.ofInt(num))) {
            throw new IllegalArgumentException("보너스 번호가 중복 됬습니다.");
        }
        return LottoNum.ofInt(num);
    }

    LottoNum getBonus() {
        return bonus;
    }

    @Override
    public String toString() {
        return "WinnerLotto{" + getLotto() +
                "bonus=" + bonus +
                '}';
    }



}
