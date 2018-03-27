package utils;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LottoSellerTest {
    private LottoSeller machine;

    @Before
    public void setUp() throws Exception {
        machine = LottoSeller.of();
    }

    @Test
    public void 천원일때_몇개살수있나() {
        assertEquals(1, LottoSeller.calcQuantity(1000));
    }

    @Test
    public void 돈이_0일때_몇개살수있나() {
        assertEquals(0, LottoSeller.calcQuantity(0));
    }
}