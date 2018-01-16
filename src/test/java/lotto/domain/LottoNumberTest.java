package lotto.domain;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LottoNumberTest {

    @Test(expected = NullPointerException.class)
    public void 로또값이_0_예외처리_null() {
        new LottoNumber(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또값이_0_예외처리() {
        new LottoNumber(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또값이_46이상_예외처리() {
        new LottoNumber(46);
    }

    @Test
    public void 로또값이_1에서_45사이_값_지정_가능한지() {
        IntStream.range(1, 45).forEach(i->
                assertTrue(new LottoNumber(i).equals(i))
        );
    }

    @Test
    public void 랜덤값이_1에서_45사이_값인지() {
        int trueCount = 0;
        int tryCount = 1000;
        for (int i = 0; i < 1000; i++) {
            LottoNumber lottoNumber = new LottoNumber();
            for (int j = 1; j < 46; j++) {
                if ((lottoNumber.equals(j))) {
                    trueCount++;
                    break;
                }
            }
        }
        assertEquals(trueCount, tryCount);
    }
}
