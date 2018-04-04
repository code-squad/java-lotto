package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LottoTest {
    List<Integer> numbers;

    @Before
    public void setup() {
        numbers = Arrays.asList(1,2,3,4,5,6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isValid() {
        Lotto lotto = new Lotto(LottoNoFactory.getLottoNo(numbers));
        lotto.isValid(LottoNoFactory.getLottoNo(Arrays.asList(1,2,3,4,5)));
    }

    @Test
    public void contains() {
        Lotto lotto = new Lotto(LottoNoFactory.getLottoNo(numbers));
        assertEquals(true, lotto.contains(new LottoNo(1)));
    }
}
