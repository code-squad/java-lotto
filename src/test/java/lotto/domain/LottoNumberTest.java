package lotto.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class LottoNumberTest {
    @Test
    public void compareToSame() throws Exception {
        LottoNumber one = LottoNumber.newInstance(1);
        LottoNumber another = LottoNumber.newInstance("1");
        assertEquals(0, one.compareTo(another));
    }

    @Test
    public void compareToDifferent() throws Exception {
        LottoNumber three = LottoNumber.newInstance(3);
        LottoNumber two = LottoNumber.newInstance("2");
        assertEquals(1, three.compareTo(two));
        assertEquals(-1, two.compareTo(three));
    }

}