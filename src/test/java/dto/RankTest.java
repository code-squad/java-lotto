package dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @Test
    public void valueOf() throws Exception {
        assertThat(Rank.valueOf(6)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(5)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(4)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(3)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(2)).isEqualTo(Rank.FAIL);
        assertThat(Rank.valueOf(1)).isEqualTo(Rank.FAIL);
    }

    @Test(expected = IllegalArgumentException.class)
    public void valueOf_6보다큰값() throws Exception {
        Rank.valueOf(7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void valueOf_음수() throws Exception {
        Rank.valueOf(-1);
    }

    @Test
    public void isFail() throws Exception {
        assertThat(Rank.FAIL.isFail()).isTrue();

        assertThat(Rank.FIRST.isFail()).isFalse();
        assertThat(Rank.SECOND.isFail()).isFalse();
        assertThat(Rank.THIRD.isFail()).isFalse();
        assertThat(Rank.FOURTH.isFail()).isFalse();
    }
}