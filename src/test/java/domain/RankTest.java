package domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RankTest {

    @Test
    public void ValueOf_1등() {
        assertThat(Rank.valueOf(6, true), is(Rank.FIRST));
    }

    @Test
    public void ValueOf_2등() {
        assertThat(Rank.valueOf(5, true), is(Rank.SECOND));
    }

    @Test
    public void ValueOf_3등() {
        assertThat(Rank.valueOf(5, false), is(Rank.THIRD));
    }

    @Test
    public void ValueOf_5등() {
        assertThat(Rank.valueOf(3, false), is(Rank.FIFTH));
    }
}
