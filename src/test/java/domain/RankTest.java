package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class RankTest {
    @Test
    public void valueOf() {
        assertThat(Rank.FIRST).isEqualTo(Rank.valueOf(6, false));
        assertThat(Rank.SECOND).isEqualTo(Rank.valueOf(5, true));
        assertThat(Rank.THIRD).isEqualTo(Rank.valueOf(5, false));
        assertThat(Rank.FOURTH).isEqualTo(Rank.valueOf(4, false));
        assertThat(Rank.FIFTH).isEqualTo(Rank.valueOf(3, false));
    }
}
