package lotto.domain;

import java.util.List;

import static lotto.domain.enums.Rank.THREE;

public class WinningLotto {
    private static List<Integer> winningLottos;
    private int bonusBall;

    private WinningLotto(List<Integer> winningLottos, int bonusBall) {
        this.winningLottos = winningLottos;
        this.bonusBall = bonusBall;
    }

    public static WinningLotto generate(List<Integer> winningLottos, int bonusBall) {
        return new WinningLotto(winningLottos, bonusBall);
    }

    public boolean isWinningTarget(Lotto lotto) {
        return getWinningCount(lotto) >= THREE.getValue();
    }

    public int getWinningCount(Lotto lotto) {
        return (int) winningLottos.stream().filter(lotto.getNumbers()::contains).count();
    }

    public static List<Integer> getWinningLottos() {
        return winningLottos;
    }

    public int getBonusBall() {
        return bonusBall;
    }
}
