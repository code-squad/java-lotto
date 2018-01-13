package domain;

import dto.LottoResult;
import dto.Rank;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {

    @Test(expected = IllegalArgumentException.class)
    public void LottoNumbers_로또번호개수가6보다작은경우() throws Exception {
        new LottoNumbers(Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                                       new LottoNumber(3), new LottoNumber(4),
                                       new LottoNumber(5)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void LottoNumbers_로또번호개수가6보다큰경우() throws Exception {
        new LottoNumbers(Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                                       new LottoNumber(3), new LottoNumber(4),
                                       new LottoNumber(5), new LottoNumber(6),
                                       new LottoNumber(7)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void LottoNumbers_로또번호에중복이있는경우() throws Exception {
        new LottoNumbers(Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                                       new LottoNumber(3), new LottoNumber(4),
                                       new LottoNumber(5), new LottoNumber(5)));
    }

    @Test
    public void LottoNumbers() throws Exception {
        new LottoNumbers(Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                                       new LottoNumber(3), new LottoNumber(4),
                                       new LottoNumber(5), new LottoNumber(6)));
    }

    @Test
    public void getWinResult() throws Exception {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                                                                   new LottoNumber(3), new LottoNumber(4),
                                                                   new LottoNumber(5), new LottoNumber(6)));

        WinningNumbers winningNumbers = new WinningNumbers(new int[]{1, 2, 3, 7, 8, 9});

        LottoResult result = lottoNumbers.getWinResult(winningNumbers);

        assertThat(result.getCountOfMatch()).isEqualTo(3);
        assertThat(result.getRank()).isEqualTo(Rank.FOURTH);
    }
}