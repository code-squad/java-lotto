package domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LottoTest {
    @Test
    public void isValid() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        Lotto lotto = new Lotto(numbers);
        assertEquals(true, lotto.isValid(numbers));
    }

    @Test
    public void contains() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        assertEquals(true, lotto.contains(new LottoNo(1)));
    }
}
