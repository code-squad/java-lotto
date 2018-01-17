package lotto.type;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnigTypeTest {

    @Test
    public void parse() {
        WinningType type = WinningType.parse(0);
        assertThat(type).isEqualTo(WinningType.NONE);

        WinningType matchAll = WinningType.parse(6);
        assertThat(matchAll).isEqualTo(WinningType.MATCH_ALL);
    }
}