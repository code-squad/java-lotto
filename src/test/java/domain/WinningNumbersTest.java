package domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumbersTest {

    private WinningNumbers winningNumbers;

    private LottoNumber bonusNumber;

    @Before
    public void setUp() throws Exception {
        bonusNumber = new LottoNumber(7);
        winningNumbers = new WinningNumbers(new Lotto(1, 2, 3, 4, 5, 6),
                                            bonusNumber);
    }

    @Test
    public void contain() throws Exception {
        assertThat(winningNumbers.contain(new LottoNumber(1))).isTrue();
        assertThat(winningNumbers.contain(new LottoNumber(2))).isTrue();

        assertThat(winningNumbers.contain(new LottoNumber(7))).isFalse();
        assertThat(winningNumbers.contain(new LottoNumber(8))).isFalse();
    }

    @Test
    public void WinnerNumbers_isMatch() throws Exception {
        assertThat(winningNumbers.isMatchBonus(new LottoNumber(7))).isTrue();
        assertThat(winningNumbers.isMatchBonus(new LottoNumber(11))).isFalse();
        assertThat(winningNumbers.isMatchBonus(new LottoNumber(5))).isFalse();
    }

    @Test(expected = IllegalArgumentException.class)
    public void WinnerNumbers_당첨숫자가6개보다작은경우() throws Exception {
        winningNumbers = new WinningNumbers(new Lotto(1, 2, 3, 4, 5), bonusNumber);
    }

    @Test(expected = IllegalArgumentException.class)
    public void WinnerNumbers_당첨숫자가6개보다큰경우() throws Exception {
        winningNumbers = new WinningNumbers(new Lotto(1, 2, 3, 4, 5, 6, 7), bonusNumber);
    }

    @Test(expected = IllegalArgumentException.class)
    public void WinnerNumbers_음수() throws Exception {
        new WinningNumbers(new Lotto(-1, 2, 3, 4, 5, 6), bonusNumber);
    }

    @Test(expected = IllegalArgumentException.class)
    public void WinnerNumbers_범위밖에숫자() throws Exception {
        new WinningNumbers(new Lotto(47, 2, 3, 4, 5, 6), bonusNumber);
    }

    @Test(expected = IllegalArgumentException.class)
    public void WinnerNumbers_중복숫자() throws Exception {
        new WinningNumbers(new Lotto(2, 2, 3, 4, 5, 6), bonusNumber);
    }

    @Test(expected = IllegalArgumentException.class)
    public void WinnerNumbers_보너스숫자가null인경우() throws Exception {
        new WinningNumbers(new Lotto(1, 2, 3, 4, 5, 6), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void WinnerNumbers_보너스숫자가중복인경우() throws Exception {
        new WinningNumbers(new Lotto(1, 2, 3, 4, 5, 7), bonusNumber);
    }
}
