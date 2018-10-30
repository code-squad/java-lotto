package domain;

import domain.vo.LottoNum;

import java.util.List;

public class WinnerLotto {
    private LottoNum bonus;
    private Lotto lotto;
    private WinnerLotto(List<String> nums,int bonus) {
        this.lotto = Lotto.ofManual(nums);
        this.bonus = setBonus(bonus);
    }

    public static WinnerLotto of(List<String> nums , int bonus) {
        return new WinnerLotto(nums,bonus);
    }

    boolean compareBonus(Lotto lotto) {
        return lotto.contains(bonus);
    }

    private LottoNum setBonus(int num) {
        if (lotto.contains(LottoNum.ofInt(num))) {
            throw new IllegalArgumentException("보너스 번호가 중복 됬습니다.");
        }
        return LottoNum.ofInt(num);
    }

    @Override
    public String toString() {
        return "WinnerLotto{" + lotto +
                "bonus=" + bonus +
                '}';
    }


    int compareLotto(Lotto lotto) {
        return lotto.compareLotto(this.lotto);
    }
}
