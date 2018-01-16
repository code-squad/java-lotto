package lotto;

import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by Joeylee on 2018-01-16.
 */
public class ResultTest {

    @Test
    public void 로또맞은개수별_카운트() throws Exception {
        Result.increaseCount(4);
        Result.increaseCount(4);
        assertEquals(new Integer(2), (Result.lottoResult.get(4)));
    }

    @Test
    public void 수익률_계산() throws Exception {
        Result.increaseCount(3);
        Result.increaseCount(3);
        assertEquals("200.0", String.valueOf(Result.rateTotal(5000)));

    }

}