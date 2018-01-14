package lotto.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LottoVendorTest {
    @Test
    public void 입력을_파싱한다() {
        assertEquals(16000 ,LottoVendor.parseMoney("16000"));
    }
/**
 * 입력값을 받는다.
 * 1000단위로 나눈다.
 * 나눈값으로 로또를 구매한다.
 */
}
