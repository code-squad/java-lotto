package domain;

import dto.LottoResult;
import dto.Rank;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test(expected = IllegalArgumentException.class)
    public void LottoNumbers_로또번호개수가6보다작은경우() throws Exception {
        new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                                new LottoNumber(3), new LottoNumber(4),
                                new LottoNumber(5)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void LottoNumbers_로또번호개수가6보다큰경우() throws Exception {
        new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                                new LottoNumber(3), new LottoNumber(4),
                                new LottoNumber(5), new LottoNumber(6),
                                new LottoNumber(7)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void LottoNumbers_로또번호에중복이있는경우() throws Exception {
        new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                                new LottoNumber(3), new LottoNumber(4),
                                new LottoNumber(5), new LottoNumber(5)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void LottoNumbers_int생성자_로또번호개수가6보다작은경우() throws Exception {
        new Lotto(1, 2, 3, 4, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void LottoNumbers_int생성자_로또번호개수가6보다큰경우() throws Exception {
        new Lotto(1, 2, 3, 4, 5, 6, 7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void LottoNumbers__int생성자_로또번호에중복이있는경우() throws Exception {
        new Lotto(1, 2, 3, 4, 5, 5);
    }

    @Test
    public void LottoNumbers() throws Exception {
        new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                                new LottoNumber(3), new LottoNumber(4),
                                new LottoNumber(5), new LottoNumber(6)));

        new Lotto(1, 2, 3, 4, 5, 6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getWinResult_인자가NULL인경우() throws Exception {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);

        lotto.getWinResult(null);
    }

    @Test
    public void getWinResult() throws Exception {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);

        WinningNumbers winningNumbers = new WinningNumbers(new int[]{1, 2, 3, 7, 8, 9},
                                                           new LottoNumber(5));

        LottoResult result = lotto.getWinResult(winningNumbers);

        assertThat(result.getCountOfMatch()).isEqualTo(3);
        assertThat(result.getRank()).isEqualTo(Rank.FIFTH);
    }

    @Test
    public void getWinResult_2등당첨() throws Exception {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);

        WinningNumbers winningNumbers = new WinningNumbers(new int[]{1, 2, 3, 4, 5, 7},
                                                           new LottoNumber(6));

        LottoResult result = lotto.getWinResult(winningNumbers);

        assertThat(result.getCountOfMatch()).isEqualTo(5);
        assertThat(result.getRank()).isEqualTo(Rank.SECOND);
    }

    @Test
    public void getWinResult_3등당첨() throws Exception {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);

        WinningNumbers winningNumbers = new WinningNumbers(new int[]{1, 2, 3, 4, 5, 7},
                                                           new LottoNumber(11));

        LottoResult result = lotto.getWinResult(winningNumbers);

        assertThat(result.getCountOfMatch()).isEqualTo(5);
        assertThat(result.getRank()).isEqualTo(Rank.THIRD);
    }
}