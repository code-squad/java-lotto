package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    public void 맞춘갯수_랭크결과() {
        assertThat(Rank.valueOf(6)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(5)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(4)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(3)).isEqualTo(Rank.FOURTH);

        for (int i = 0; i < 2; i++) {
            assertThat(Rank.valueOf(i)).isEqualTo(Rank.FAIL);
        }
    }
}
