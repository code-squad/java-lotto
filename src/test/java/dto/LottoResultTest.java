package dto;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LottoResultTest {

    @Test
    public void Result() {
        LottoResult result = new LottoResult(6);

        assertThat(result.getRank()).isEqualTo(Rank.FIRST);
    }
}