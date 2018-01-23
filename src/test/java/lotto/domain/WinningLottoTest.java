package lotto.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    @Test
    public void match() {
        WinningLotto wLotto = new WinningLotto("1,2,3,4,5,6", 7);

        Lotto lotto = new Lotto("1,2,3,4,5,6");
        assertThat(wLotto.match(lotto)).isEqualTo(6);

        Lotto matchFive = new Lotto("1,2,3,4,5,9");
        assertThat(wLotto.match(matchFive)).isEqualTo(5);

        Lotto matchNone = new Lotto("10,11,23,14,15,16");
        assertThat(wLotto.match(matchNone)).isEqualTo(0);

    }

    @Test
    public void isBonus() {
        WinningLotto wLotto = new WinningLotto("1,2,3,4,5,6", 7);

        Lotto match = new Lotto("1,2,3,4,5,7");
        assertThat(wLotto.isBonus(match)).isTrue();

        Lotto notMatch = new Lotto("1,2,3,4,5,6");
        assertThat(wLotto.isBonus(notMatch)).isFalse();

    }
}

