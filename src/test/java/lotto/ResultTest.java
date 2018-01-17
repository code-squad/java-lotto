package lotto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by Joeylee on 2018-01-16.
 */
public class ResultTest {

    private Result result;

    @Before
    public void setUp() throws Exception {
        result  = new Result();
    }

    @Test
    public void 로또맞은개수별_카운트() throws Exception {
        result.increaseCount(4);
        result.increaseCount(4);
        assertEquals(new Integer(2), (result.lottoResult.get(4)));
    }

    @Test
    public void 수익률_계산() throws Exception {
        result.increaseCount(3);
        result.increaseCount(3);
        assertEquals("100", String.valueOf(result.rateTotal(5000)));

    }

}