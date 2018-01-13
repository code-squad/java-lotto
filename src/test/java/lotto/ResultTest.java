package lotto;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ResultTest {

    @Test
    public void Result() {
        Result result = new Result(6);

        assertThat(result.getRank()).isEqualTo(Rank.FIRST);
    }
}