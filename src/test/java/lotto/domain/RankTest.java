package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    public void print_테스트() {
        Rank rank = Rank.valueOf(Rank.FIRST.name());

        assertThat(rank.toString(2))
                .isEqualTo("6개 일치 (2000000000원) - 2개");
    }

    @Test
    public void BONUS_테스트() {
        Rank rank = Rank.valueOf(Rank.BONUS.name());

        assertThat(rank.toString(1))
                .isEqualTo("5개 일치, 보너스 볼 일치(30000000원) - 1개");
    }

    @Test
    public void 당첨_3등() {
        assertThat(Rank.valueOf(3, false))
                .isEqualTo(Rank.FORTH);
    }

    @Test
    public void 당첨_보너스() {
        assertThat(Rank.valueOf(5, true))
                .isEqualTo(Rank.BONUS);

        assertThat(Rank.valueOf(5, false))
                .isEqualTo(Rank.SECOND);
    }
}