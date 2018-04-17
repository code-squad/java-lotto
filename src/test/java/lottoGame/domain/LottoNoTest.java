package lottoGame.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class LottoNoTest {

    @Test(expected = IllegalArgumentException.class)
    public void 로또수1미만테스트예외테스트() {
        new LottoNo(-3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또수45초과시예외테스트() {
        new LottoNo(46);
    }
}