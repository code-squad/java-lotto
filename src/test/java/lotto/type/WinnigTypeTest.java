package lotto.type;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnigTypeTest {

    @Test
    public void parse() {
        WinningType type = WinningType.parse(0, false);
        assertThat(type).isEqualTo(WinningType.NONE);

        WinningType matchFive = WinningType.parse(5, false);
        assertThat(matchFive).isEqualTo(WinningType.MATCH_FIVE);

        WinningType matchFiveWithBonus = WinningType.parse(5, true);
        assertThat(matchFiveWithBonus).isEqualTo(WinningType.MATCH_FIVE_WITH_BONUS);

        WinningType matchAll = WinningType.parse(6, false);
        assertThat(matchAll).isEqualTo(WinningType.MATCH_ALL);
    }
}