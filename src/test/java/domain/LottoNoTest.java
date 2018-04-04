package domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LottoNoTest {
    @Test
    public void generateLottoNo() {
        LottoNo lottoNo = new LottoNo(1);
        assertEquals(true, lottoNo.isValid(4));
    }
}
