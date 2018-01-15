package dto;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LottoResultTest {

    @Test
    public void Result() {
        LottoResult result = new LottoResult(6, false);
        assertThat(result.getRank()).isEqualTo(Rank.FIRST);

        result = new LottoResult(5, true);
        assertThat(result.getRank()).isEqualTo(Rank.SECOND);

        result = new LottoResult(5, false);
        assertThat(result.getRank()).isEqualTo(Rank.THIRD);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Result_0보다작은숫자() {
        LottoResult result = new LottoResult(-1, false);
        assertThat(result.getRank()).isEqualTo(Rank.FIRST);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Result_6보다큰숫자() {
        LottoResult result = new LottoResult(7, false);
        assertThat(result.getRank()).isEqualTo(Rank.FIRST);
    }
}