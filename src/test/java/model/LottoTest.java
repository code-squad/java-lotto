package model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    UserLotto lotto;

    @Before
    public void setup() {
        lotto = new UserLotto();
    }

    @Test
    public void generateTest() {
        assertThat(lotto.getNumbers().size())
                .isEqualTo((int) (lotto.getNumbers().stream().distinct().count()));
    }

    @Test
    public void compareTest() {
        UserLotto lotto1 = new UserLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        UserLotto lotto2 = new UserLotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        UserLotto lotto3 = new UserLotto(Arrays.asList(1, 2, 3, 4, 7, 8));

        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 27);

        assertThat(winningLotto.compare(lotto1)).isEqualTo(6);
        assertThat(winningLotto.compare(lotto2)).isEqualTo(5);
        assertThat(winningLotto.compare(lotto3)).isEqualTo(4);
    }

    @Test
    public void compareBonusTest() {
        UserLotto lotto = new UserLotto(Arrays.asList(1, 2, 3, 4, 5, 27));

        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 27);

        assertThat(winningLotto.compare(lotto)).isEqualTo(5);
        assertThat(winningLotto.compareBonus(lotto)).isEqualTo(true);
    }
}
