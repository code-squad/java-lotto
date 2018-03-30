package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LottoTest {
    private Lotto lotto1;
    private Lotto lotto2;

    @Before
    public void setUp() throws Exception {
        lotto1 = new Lotto(Arrays.asList(new LottoNum(1), new LottoNum(2), new LottoNum(3), new LottoNum(4), new LottoNum(5), new LottoNum(6)));
        lotto2 = new Lotto(Arrays.asList(new LottoNum(3), new LottoNum(7), new LottoNum(2), new LottoNum(8), new LottoNum(4), new LottoNum(1)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호_길이부족() {
        new Lotto(Arrays.asList(new LottoNum(1), new LottoNum(2), new LottoNum(3)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 중복된번호_생성() {
        new Lotto(Arrays.asList(new LottoNum(1), new LottoNum(1), new LottoNum(1), new LottoNum(4), new LottoNum(5), new LottoNum(6)));
    }

    @Test
    public void 번호_매칭() {
        assertEquals(4, lotto1.match(lotto2));
    }

    @Test
    public void 번호_포함하고있다() {
        assertTrue(lotto1.isContainNumber(new LottoNum(2)));
    }

    @Test
    public void 번호_포함하고있지않다() {
        assertFalse(lotto1.isContainNumber(new LottoNum(10)));
    }

    @Test
    public void 번호_순서대로_나열하기() {
        assertEquals("[1, 2, 3, 4, 5, 6]", lotto1.toString());
    }
}