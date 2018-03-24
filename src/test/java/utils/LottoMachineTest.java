package utils;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LottoMachineTest {
    private LottoMachine machine;

    @Before
    public void setUp() throws Exception {
        machine = LottoMachine.of();
    }

    @Test
    public void 천원일때_몇개살수있나() {
        assertEquals(1, LottoMachine.calcQuantity(1000));
    }

    @Test
    public void 돈이_0일때_몇개살수있나() {
        assertEquals(0, LottoMachine.calcQuantity(0));
    }
}