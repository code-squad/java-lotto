package domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    public void test() {
        Lottos lottos = new Lottos();
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(lottos.match(new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7)).get(0)).isEqualTo(Rank.FIRST);
        assertThat(lottos.match(new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 7), 6)).get(0)).isEqualTo(Rank.SECOND);
        assertThat(lottos.match(new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 7), 8)).get(0)).isEqualTo(Rank.THIRD);
    }
}
