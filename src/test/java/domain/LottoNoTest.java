package domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LottoNoTest {
    LottoNo lottoNo;

    @Test
    public void generateLottoNo() {
        lottoNo = new LottoNo(4);
        assertEquals(true, lottoNo.hasNumber(4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void generateOverLottoNo() {
        new LottoNo("46");
    }

    @Test(expected = IllegalArgumentException.class)
    public void generateZeroLottoNo() {
        new LottoNo("0");
    }
}
