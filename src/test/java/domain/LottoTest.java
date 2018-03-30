package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LottoTest {
    private Lotto lotto1;
    private Lotto lotto2;

    /*@Before
    public void setUp() throws Exception {
        lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lotto2 = new Lotto(Arrays.asList(3, 7, 2, 8, 4, 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호_길이부족() {
        new Lotto(Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호_마이너스값() {
        new Lotto(Arrays.asList(-1, -2, -3, 4, 5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호_벗어나는범위() {
        new Lotto(Arrays.asList(0, 100, 46, 44, 1));
    }

    @Test
    public void 번호_매칭() {
        assertEquals(4, lotto1.match(lotto2));
    }

    @Test
    public void 번호_포함하고있다() {
        assertTrue(lotto1.isContainNumber(2));
    }

    @Test
    public void 번호_포함하고있지않다() {
        assertFalse(lotto1.isContainNumber(10));
    }

    @Test
    public void 번호_순서대로_나열하기() {
        assertEquals("[1, 2, 3, 4, 5, 6]", lotto1.toString());
    }*/
}