package domain;

import java.util.Arrays;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    @Test
    public void isBonusBall() {
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto lotto = LottoFactory.generateTheLotto(set);
        Lotto otherLotto = LottoFactory.generateTheLotto(set2);
        WinningLotto winningLotto = LottoFactory.generateWinningLotto(set, 7);

        assertThat(winningLotto.isHitBonusBall(lotto)).isFalse();
        assertThat(winningLotto.isHitBonusBall(otherLotto)).isTrue();
    }
}
