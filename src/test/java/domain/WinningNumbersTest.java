package domain;

import dto.LottoResult;
import dto.Rank;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumbersTest {

    private WinningNumbers winningNumbers;

    private List<Lotto> lottos;

    @Before
    public void setUp() throws Exception {
        winningNumbers = new WinningNumbers(new int[]{1, 2, 3, 4, 5, 6});
        lottos = Collections.singletonList(new Lotto(new int[]{1, 3, 5, 7, 9, 11}));

    }

    @Test
    public void contain() throws Exception {
        assertThat(winningNumbers.contain(new LottoNumber(1))).isTrue();
        assertThat(winningNumbers.contain(new LottoNumber(2))).isTrue();

        assertThat(winningNumbers.contain(new LottoNumber(7))).isFalse();
        assertThat(winningNumbers.contain(new LottoNumber(8))).isFalse();
    }

    @Test(expected = IllegalArgumentException.class)
    public void WinnerNumbers_당첨숫자가6개보다작은경우() throws Exception {
        winningNumbers = new WinningNumbers(new int[]{1, 2, 3, 4, 5});
    }

    @Test(expected = IllegalArgumentException.class)
    public void WinnerNumbers_당첨숫자가6개보다큰경우() throws Exception {
        winningNumbers = new WinningNumbers(new int[]{1, 2, 3, 4, 5, 6, 7});
    }

    @Test(expected = IllegalArgumentException.class)
    public void WinnerNumbers_음수() throws Exception {
        new WinningNumbers(new int[]{-1, 2, 3, 4, 5, 6});
    }

    @Test(expected = IllegalArgumentException.class)
    public void WinnerNumbers_범위밖에숫자() throws Exception {
        new WinningNumbers(new int[]{47, 2, 3, 4, 5, 6});
    }

    @Test(expected = IllegalArgumentException.class)
    public void WinnerNumbers_중복숫자() throws Exception {
        new WinningNumbers(new int[]{2, 2, 3, 4, 5, 6});
    }

    @Test
    public void execute() throws Exception {
        List<LottoResult> results = winningNumbers.match(lottos);

        assertThat(results).isNotEmpty();
        assertThat(results.size()).isEqualTo(1);
        assertThat(results.get(0).getCountOfMatch()).isEqualTo(3);
        assertThat(results.get(0).getRank()).isEqualTo(Rank.FOURTH);
    }

    @Test(expected = IllegalArgumentException.class)
    public void execute_빈리스트인경우() throws Exception {
        winningNumbers.match(Collections.EMPTY_LIST);

    }
}
