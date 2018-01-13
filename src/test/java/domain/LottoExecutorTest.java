package domain;

import dto.LottoResult;
import dto.Rank;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoExecutorTest {

    private List<Lotto> lottos;
    private WinningNumbers winningNumbers;

    @Before
    public void setUp() throws Exception {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                                                                   new LottoNumber(3), new LottoNumber(4),
                                                                   new LottoNumber(5), new LottoNumber(6)));

        lottos = Collections.singletonList(new Lotto(lottoNumbers));
        winningNumbers = new WinningNumbers(new int[]{1, 3, 5, 7, 8, 9});
    }

    @Test
    public void execute() throws Exception {
        List<LottoResult> results = LottoExecutor.execute(lottos, winningNumbers);

        assertThat(results).isNotEmpty();
        assertThat(results.size()).isEqualTo(1);
        assertThat(results.get(0).getCountOfMatch()).isEqualTo(3);
        assertThat(results.get(0).getRank()).isEqualTo(Rank.FOURTH);
    }

    @Test(expected = IllegalArgumentException.class)
    public void execute_빈리스트인경우() throws Exception {
        LottoExecutor.execute(Collections.EMPTY_LIST, winningNumbers);

    }

    @Test(expected = IllegalArgumentException.class)
    public void execute_WinningNumber가널인경우() throws Exception {
        LottoExecutor.execute(lottos, null);
    }
}