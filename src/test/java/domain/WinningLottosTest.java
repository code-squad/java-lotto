package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningLottosTest {
    private WinningLottos winningLottos;

    @Before
    public void setUp() throws Exception {
        winningLottos = new WinningLottos(Arrays.asList(new WinningLotto(3, false),
                                                        new WinningLotto(1, false),
                                                        new WinningLotto(4, false)));
    }

    @Test
    public void getCountOfRank() throws Exception {
        assertThat(winningLottos.getCountOfRank(Rank.FIRST)).isEqualTo(0);
        assertThat(winningLottos.getCountOfRank(Rank.SECOND)).isEqualTo(0);
        assertThat(winningLottos.getCountOfRank(Rank.THIRD)).isEqualTo(0);
        assertThat(winningLottos.getCountOfRank(Rank.FOURTH)).isEqualTo(1);
        assertThat(winningLottos.getCountOfRank(Rank.FIFTH)).isEqualTo(1);
        assertThat(winningLottos.getCountOfRank(Rank.FAIL)).isEqualTo(1);
    }

    @Test
    public void getRevenue() throws Exception {
        assertThat(winningLottos.getRevenue()).isEqualTo((50000 + 5000) / (double) 3000 * 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void WinninLottos_생성자가NULL인경우() throws Exception {
        new WinningLottos(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void WinninLottos_생성자가빈리스트인경우() throws Exception {
        new WinningLottos(Collections.emptyList());
    }
}