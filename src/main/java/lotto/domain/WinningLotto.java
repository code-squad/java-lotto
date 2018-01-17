package lotto.domain;

import java.util.List;

import static lotto.domain.enums.Rank.THREE;

public class WinningLotto {
    private static List<Integer> winningLottos;
    private int bonusBall;

    private WinningLotto(Lotto winningLotto, int bonusBall) {
        this.winningLottos = winningLotto.getNumbers();
        this.bonusBall = bonusBall;
    }

    public static WinningLotto generate(Lotto winningLotto, int bonusBall) {
        return new WinningLotto(winningLotto, bonusBall);
    }

    public boolean isWinningTarget(Lotto lotto) {
        return getWinningCount(lotto) >= THREE.getValue();
    }

    public int getWinningCount(Lotto lotto) {
        return (int) winningLottos.stream().filter(lotto.getNumbers()::contains).count();
    }

    public int getBonusBall() {
        return bonusBall;
    }
}
