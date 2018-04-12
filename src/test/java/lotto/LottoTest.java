package lotto;

import com.sun.javaws.exceptions.InvalidArgumentException;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sangsik.kim
 */
public class LottoTest {
    private WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 10);

    @Test
    public void 당첨확인_1등() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lotto.match(this.winningLotto)).isEqualTo(Rank.FIRST);
    }

    @Test
    public void 당첨확인_2등() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10));

        assertThat(lotto.match(this.winningLotto)).isEqualTo(Rank.SECOND);
    }

    @Test
    public void 당첨확인_3등() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 20));

        assertThat(lotto.match(this.winningLotto)).isEqualTo(Rank.THIRD);
    }

    @Test
    public void 당첨확인_4등() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 20, 30));

        assertThat(lotto.match(this.winningLotto)).isEqualTo(Rank.FOURTH);
    }

    @Test
    public void 당첨확인_5등() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 10, 20, 30));

        assertThat(lotto.match(this.winningLotto)).isEqualTo(Rank.FIFTH);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_숫자개수_유효성() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_숫자중복_유효성() {
        Lotto lotto = new Lotto(Arrays.asList(1, 1, 1, 4, 5, 6));
    }
}
