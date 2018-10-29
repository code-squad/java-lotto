package domain;

import java.util.Arrays;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class WinningLottoTest {
    @Test (expected = IllegalArgumentException.class)
    public void generateWinningLottoWithException() {
        Set<Integer> set = new HashSet<>(Arrays.asList(1,2,3,4,5,6));
        WinningLottoFactory.generateWinningLotto(set, 5);
    }

    @Test
    public void generateWinningLotto(){
        Set<Integer> set = new HashSet<>(Arrays.asList(1,2,3,4,5,6));
        assertTrue(WinningLottoFactory.generateWinningLotto(set, 7) instanceof WinningLotto);
    }

    @Test
    public void isBonusBall() {
        Set<Integer> set = new HashSet<>(Arrays.asList(1,2,3,4,5,6));
        List<String> list = Arrays.asList("1,2,3,4,5,6" , "1,2,3,4,5,7");
        LottoBundleFactory manual = new ManualLottoBundleFactory(list);
        LottoBundle lottoBundle = manual.generate(2);
        WinningLotto winningLotto = WinningLottoFactory.generateWinningLotto(set, 7);

        assertThat(winningLotto.isHitBonusBall(lottoBundle.getALotto(0))).isFalse();
        assertThat(winningLotto.isHitBonusBall(lottoBundle.getALotto(1))).isTrue();
    }
}
