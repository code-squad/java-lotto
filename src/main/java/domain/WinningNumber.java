package domain;

import java.util.List;

public class WinningNumber {
    private List<Integer> winningLottos;
    private int bonusNum;

    public WinningNumber(List<Integer> winningLottos, int bonusNum) {
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
