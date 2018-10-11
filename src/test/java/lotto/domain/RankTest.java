package lotto.domain;

import lotto.domain.Rank;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    public void 보너스번호구별확인() {
        Rank rank = Rank.valueOf(5, true);
        assertThat(rank.getWinningMoney()).isEqualTo(Rank.SECOND.getWinningMoney());
    }

    @Test
    public void 매칭1개() {
        Rank rank = Rank.valueOf(1, false);
        assertThat(rank.getWinningMoney()).isEqualTo(Rank.MISS.getWinningMoney());

    }
}
