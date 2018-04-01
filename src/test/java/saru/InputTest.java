package saru;

import org.junit.Test;
import saru.view.Input;

import static junit.framework.TestCase.assertEquals;

public class InputTest {
    @Test
    public void 로또구매() {
        assertEquals(14, Input.buy(14000));
    }
}
