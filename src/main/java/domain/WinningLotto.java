package domain;

import java.util.List;

public class WinningLotto {
    private List<Integer> winningLottos;
    private int bonusNum;

    public WinningLotto(List<Integer> winningLottos, int bonusNum) {
        this.winningLottos = winningLottos;
        this.bonusNum = bonusNum;
    }

    public List<Integer> getWinningLottos() {
        return winningLottos;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
