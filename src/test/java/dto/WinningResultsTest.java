package dto;

import domain.WinningLotto;
import domain.WinningLottos;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultsTest {

    private WinningResults results;

    @Before
    public void setUp() throws Exception {
        WinningLottos winningLottos = new WinningLottos(Arrays.asList(new WinningLotto(3, false),
                                                                      new WinningLotto(5, true),
                                                                      new WinningLotto(3, true),
                                                                      new WinningLotto(1, false)));
        results = new WinningResults(winningLottos);
    }

    @Test
    public void getWinningResults() throws Exception {
        List<WinningResults.WinningResult> winningResults = results.getWinningResults();

        assertThat(winningResults.size()).isEqualTo(5);
        assertThat(winningResults.get(0).toString()).isEqualTo("3개 일치 (5,000원) - 2개");
        assertThat(winningResults.get(1).toString()).isEqualTo("4개 일치 (50,000원) - 0개");
        assertThat(winningResults.get(2).toString()).isEqualTo("5개 일치 (1,500,000원) - 0개");
        assertThat(winningResults.get(3).toString()).isEqualTo("5개 일치, 보너스 볼 일치 (30,000,000원) - 1개");
        assertThat(winningResults.get(4).toString()).isEqualTo("6개 일치 (2,000,000,000원) - 0개");
    }

    @Test
    public void getBenefit() throws Exception {
        assertThat(results.getBenefit()).isEqualTo(750250.0);
    }

}