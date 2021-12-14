package vo;

import org.junit.Test;
import vo.Rank;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    public void 맞춘갯수_랭크결과() {
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);

        for (int i = 0; i < 2; i++) {
            assertThat(Rank.valueOf(i, false)).isEqualTo(Rank.FAIL);
        }
    }
}
