package lotto.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 테스트_1등() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1,2,3,4,5,6)), 7);
        Rank result = lotto.match(winningLotto);
        assertThat(result).isEqualTo(Rank.FIRST);
    }

    @Test
    public void 테스트_2등() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1,2,3,7,8,9)), 6);
        Rank result = lotto.match(winningLotto);
        assertThat(result).isEqualTo(Rank.SECOND);
    }

    @Test
    public void 테스트_3등() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1,2,3,4,5,9)), 10);
        Rank result = lotto.match(winningLotto);
        assertThat(result).isEqualTo(Rank.THIRD);
    }

    @Test
    public void 테스트_4등() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1,2,3,4,7,9)), 10);
        Rank result = lotto.match(winningLotto);
        assertThat(result).isEqualTo(Rank.FOURTH);
    }

    @Test
    public void 테스트_5등() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1,2,3,7,8,9)), 10);
        Rank result = lotto.match(winningLotto);
        assertThat(result).isEqualTo(Rank.FIFTH);
    }

    @Test
    public void 테스트_당첨실패() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1,2,7,8,9,12)), 10);
        Rank result = lotto.match(winningLotto);
        assertThat(result).isEqualTo(Rank.NONE);
    }
}
