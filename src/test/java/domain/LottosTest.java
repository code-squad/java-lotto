package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    private Lottos lottos;

    private WinningNumbers winningNumbers;

    @Before
    public void setUp() throws Exception {
        lottos = new Lottos(Arrays.asList(new Lotto(1, 3, 5, 7, 9, 11),
                                          new Lotto(8, 9, 10, 11, 12, 13)));
        winningNumbers = new WinningNumbers(new Lotto(1, 2, 3, 4, 5, 6), new LottoNumber(7));
    }

    @Test(expected = IllegalArgumentException.class)
    public void Lottos_생성자인자가널인경우() throws Exception {
        new Lottos((List<Lotto>) null);

    }

    @Test(expected = IllegalArgumentException.class)
    public void Lottos_생성자인자가빈리스트인경우() throws Exception {
        new Lottos(Collections.EMPTY_LIST);
    }

    @Test
    public void Lottos_인자중하나가널인경우() throws Exception {
        Lottos mergedLottos = new Lottos(lottos, null);
        assertThat(mergedLottos.size()).isEqualTo(lottos.size());
    }

    @Test
    public void Lottos_모든인자가널이아닌경우() throws Exception {
        Lottos l = new Lottos(Arrays.asList(new Lotto(1, 3, 5, 7, 9, 11),
                                            new Lotto(8, 9, 10, 11, 12, 13)));
        Lottos mergedLottos = new Lottos(lottos, l);
        assertThat(mergedLottos.size()).isEqualTo(4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Lottos_모든인자가널인경우() throws Exception {
        Lottos mergedLottos = new Lottos(null, null);
        assertThat(mergedLottos.size()).isEqualTo(lottos.size());
    }

    @Test
    public void match() throws Exception {
        WinningLottos winningLottos = lottos.match(winningNumbers);

        assertThat(winningLottos.getCountOfRank(Rank.FIFTH)).isEqualTo(1);
        assertThat(winningLottos.getCountOfRank(Rank.FAIL)).isEqualTo(1);

        assertThat(winningLottos.getCountOfRank(Rank.FIRST)).isEqualTo(0);
        assertThat(winningLottos.getCountOfRank(Rank.SECOND)).isEqualTo(0);
        assertThat(winningLottos.getCountOfRank(Rank.THIRD)).isEqualTo(0);
        assertThat(winningLottos.getCountOfRank(Rank.FOURTH)).isEqualTo(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void match_널인경우() throws Exception {
        lottos.match(null);
    }

    @Test
    public void match_2등인경우() throws Exception {
        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(1, 3, 5, 7, 9, 10), new LottoNumber(11));

        WinningLottos winningLottos = lottos.match(winningNumbers);

        assertThat(winningLottos.getCountOfRank(Rank.SECOND)).isEqualTo(1);
        assertThat(winningLottos.getCountOfRank(Rank.FAIL)).isEqualTo(1);

        assertThat(winningLottos.getCountOfRank(Rank.FIRST)).isEqualTo(0);
        assertThat(winningLottos.getCountOfRank(Rank.THIRD)).isEqualTo(0);
        assertThat(winningLottos.getCountOfRank(Rank.FOURTH)).isEqualTo(0);
        assertThat(winningLottos.getCountOfRank(Rank.FIFTH)).isEqualTo(0);
    }
}