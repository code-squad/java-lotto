package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    public void print_테스트() {
        Rank rank = Rank.valueOf(Rank.FIRST.name());

        assertThat(rank.print(2))
                .isEqualTo("6개 일치 (2000000000원) - 2개");
    }

    @Test
    public void BONUS_테스트() {
        Rank rank = Rank.valueOf(Rank.BONUS.name());

        assertThat(rank.print(1))
                .isEqualTo("5개 일치, 보너스 볼 일치(30000000원) - 1개");
    }
}