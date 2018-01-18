package lotto.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class LottoNumberTest {
    @Test
    public void compareToSame() throws Exception {
        LottoNumber one = LottoNumber.of(1);
        LottoNumber another = LottoNumber.of("1");
        assertEquals(0, one.compareTo(another));
    }

    @Test
    public void compareToDifferent() throws Exception {
        LottoNumber three = LottoNumber.of(3);
        LottoNumber two = LottoNumber.of("2");
        assertEquals(1, three.compareTo(two));
        assertEquals(-1, two.compareTo(three));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidNumber() throws Exception {
        LottoNumber invalid = LottoNumber.of("e");
    }

}