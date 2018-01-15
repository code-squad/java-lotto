package lotto.domain;

import lotto.domain.enums.Rank;

import java.util.Arrays;
import java.util.List;

import static lotto.domain.enums.Rank.*;

public class WinningLotto {
    private static List<Integer> winningLottos;
    private static int bonusBall;

    private WinningLotto(List<Integer> winningLottos, int bonusBall) {
        this.winningLottos = winningLottos;
        this.bonusBall = bonusBall;
    }

    public static WinningLotto generate(List<Integer> winningLottos, int bonusBall) {
        return new WinningLotto(winningLottos, bonusBall);
    }

    public static Rank match(Lotto lotto) {
        if(FOUR.isEqualCount(getWinningCount(lotto)) && lotto.hasBonusBall(bonusBall)) return FIVE_DOUBLE;

        return Arrays.stream(Rank.values())
                .filter(lottoCorrectCount -> lottoCorrectCount.isEqualCount(getWinningCount(lotto)))
                .findFirst().get();
    }

    public static boolean isWinningTarget(Lotto lotto) {
        return getWinningCount(lotto) >= THREE.getValue();
    }

    private static int getWinningCount(Lotto lotto) {
        return (int) winningLottos.stream().filter(lotto.getNumbers()::contains).count();
    }
}
