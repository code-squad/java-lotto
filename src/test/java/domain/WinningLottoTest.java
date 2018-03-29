package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class WinningLottoTest {
    private WinningLotto winningLotto;
    private Lotto userLotto;

    @Before
    public void setUp() throws Exception {
        winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 9);
        userLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 9));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 당첨번호_보너스번호_중복_생성() {
        new WinningLotto(new Lotto(Arrays.asList(1,2,3,4,5,6)), 6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 유효하지않은_범위의_보너스번호로_생성() {
        new WinningLotto(new Lotto(Arrays.asList(1,2,3,4,5,6)), -1);
    }

    @Test
    public void 당첨번호_매칭() {
        assertEquals(5, winningLotto.match(userLotto));
    }

    @Test
    public void 보너스번호_매칭() {
        assertTrue(winningLotto.matchBonus(userLotto));
    }
}