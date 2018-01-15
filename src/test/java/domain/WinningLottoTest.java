package domain;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class WinningLottoTest {

    @Test
    public void Result() {
        WinningLotto result = new WinningLotto(6, false);
        assertThat(result.getRank()).isEqualTo(Rank.FIRST);

        result = new WinningLotto(5, true);
        assertThat(result.getRank()).isEqualTo(Rank.SECOND);

        result = new WinningLotto(5, false);
        assertThat(result.getRank()).isEqualTo(Rank.THIRD);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Result_0보다작은숫자() {
        WinningLotto result = new WinningLotto(-1, false);
        assertThat(result.getRank()).isEqualTo(Rank.FIRST);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Result_6보다큰숫자() {
        WinningLotto result = new WinningLotto(7, false);
        assertThat(result.getRank()).isEqualTo(Rank.FIRST);
    }
}