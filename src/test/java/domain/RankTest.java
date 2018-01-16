package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @Test
    public void valueOf() throws Exception {
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(2, false)).isEqualTo(Rank.FAIL);
        assertThat(Rank.valueOf(1, false)).isEqualTo(Rank.FAIL);
    }

    @Test
    public void valueOf_2등이외matchBonus가true인경우() throws Exception {
        assertThat(Rank.valueOf(6, true)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(4, true)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(3, true)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(2, true)).isEqualTo(Rank.FAIL);
        assertThat(Rank.valueOf(1, true)).isEqualTo(Rank.FAIL);
    }

    @Test(expected = IllegalArgumentException.class)
    public void valueOf_6보다큰값() throws Exception {
        Rank.valueOf(7, false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void valueOf_음수() throws Exception {
        Rank.valueOf(-1, false);
    }

    @Test
    public void isFail() throws Exception {
        assertThat(Rank.FAIL.isFail()).isTrue();

        assertThat(Rank.FIRST.isFail()).isFalse();
        assertThat(Rank.SECOND.isFail()).isFalse();
        assertThat(Rank.THIRD.isFail()).isFalse();
        assertThat(Rank.FOURTH.isFail()).isFalse();
        assertThat(Rank.FIFTH.isFail()).isFalse();
    }
}