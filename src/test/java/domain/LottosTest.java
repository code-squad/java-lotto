package domain;

import dto.LottoResult;
import dto.Rank;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    private Lottos lottos;

    private WinningNumbers winningNumbers;

    @Before
    public void setUp() throws Exception {
        lottos = new Lottos(Arrays.asList(new Lotto(1, 3, 5, 7, 9, 11),
                                          new Lotto(8, 9, 10, 11, 12, 13)));
        winningNumbers = new WinningNumbers(new int[]{1, 2, 3, 4, 5, 6}, new LottoNumber(7));
    }

    @Test
    public void match() throws Exception {
        List<LottoResult> results = lottos.match(winningNumbers);

        assertThat(results).isNotEmpty();
        assertThat(results.size()).isEqualTo(2);
        assertThat(results.get(0).getCountOfMatch()).isEqualTo(3);
        assertThat(results.get(0).getRank()).isEqualTo(Rank.FIFTH);

        assertThat(results.get(1).getCountOfMatch()).isEqualTo(0);
        assertThat(results.get(1).getRank()).isEqualTo(Rank.FAIL);
    }

    @Test(expected = IllegalArgumentException.class)
    public void match_널인경우() throws Exception {
        lottos.match(null);
    }

    @Test
    public void match_2등인경우() throws Exception {
        WinningNumbers winningNumbers = new WinningNumbers(new int[]{1, 3, 5, 7, 9, 10}, new LottoNumber(11));

        List<LottoResult> results = lottos.match(winningNumbers);

        assertThat(results).isNotEmpty();
        assertThat(results.size()).isEqualTo(2);
        assertThat(results.get(0).getCountOfMatch()).isEqualTo(5);
        assertThat(results.get(0).getRank()).isEqualTo(Rank.SECOND);

        assertThat(results.get(1).getCountOfMatch()).isEqualTo(2);
        assertThat(results.get(1).getRank()).isEqualTo(Rank.FAIL);
    }
}