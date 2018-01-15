import org.junit.Test;

import java.util.List;

import lotto.view.Input;

import static java.util.Optional.of;
import static org.junit.Assert.assertEquals;

public class InputTest {

    @Test(expected = IllegalArgumentException.class)
    public void 금액입력이_천원단위가_맞는가() {
        Input.init("14001").getMoney();
    }

    @Test
    public void 당첨번호를_올바르게_입력받았는가() {
        List<Integer> winNumbers = Input.init("1, 2, 3, 4, 5, 6").winNumbers();
        assertEquals(of(1).get(), winNumbers.get(0));
        assertEquals(of(2).get(), winNumbers.get(1));
        assertEquals(of(3).get(), winNumbers.get(2));
    }
}
