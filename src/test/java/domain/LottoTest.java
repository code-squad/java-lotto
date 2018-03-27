package domain;

import org.junit.Before;
import org.junit.Test;


import java.util.Arrays;

import static org.junit.Assert.*;

public class LottoTest {

    @Test(expected = IllegalArgumentException.class)
    public void 부족한_로또_개수() {
        Lotto.of(Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test
    public void 유저_로또_개수() {
        Lotto lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertEquals(true, lotto instanceof UserLotto);
    }

    @Test
    public void 당첨_로또_개수() {
        Lotto lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertEquals(true, lotto instanceof WinningLotto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 벗어나는_범위() {
        Lotto.of(Arrays.asList(46, 48, 24, 31, -1, 0));
    }

    @Test
    public void 정상_범위() {
        Lotto.of(Arrays.asList(25, 17, 5, 14, 19, 32));
    }
}