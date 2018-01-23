package lottoGame.domain;

import java.util.List;

public class WinningLotto extends Lotto{
    int bonusNum;

    public WinningLotto(List<Integer> nums, int bonusNum) {
        super(nums);
        this.bonusNum = bonusNum;
    }
}
