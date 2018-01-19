package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Moonchan on 2018. 1. 18..
 */
public class PrizeTest {

    @Test
    public void 번호일치규칙() {
        assertThat(Prize.FIRST.checkWinningRule(0)).isEqualTo(true);
        assertThat(Prize.SECOND.checkWinningRule(1)).isEqualTo(true);
        assertThat(Prize.THIRD.checkWinningRule(1)).isEqualTo(true);
        assertThat(Prize.FOURTH.checkWinningRule(2)).isEqualTo(true);
        assertThat(Prize.FIFTH.checkWinningRule(3)).isEqualTo(true);
    }

    @Test
    public void 보너스규칙() {
        assertThat(Prize.FIRST.checkBonusRule(true)).isEqualTo(true);
        assertThat(Prize.FIRST.checkBonusRule(false)).isEqualTo(true);
        assertThat(Prize.SECOND.checkBonusRule(true)).isEqualTo(true);
        assertThat(Prize.SECOND.checkBonusRule(false)).isEqualTo(false);
    }
}
