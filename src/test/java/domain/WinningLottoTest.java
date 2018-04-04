package domain;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class WinningLottoTest {
    @Test
    public void generateWinningLotto() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1,2,3,4,5,6), 7);
        assertEquals(false, winningLotto.hasBonusNo());
    }
}
