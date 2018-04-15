package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

@SuppressWarnings("NonAsciiCharacters")
public class RankTest {
    @Test
    public void valueOf_6개_매치_1등() {
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
    }

    @Test
    public void valueOf_2개_매치_MISS() {
        assertThat(Rank.valueOf(2, false)).isEqualTo(Rank.MISS);
    }
}
