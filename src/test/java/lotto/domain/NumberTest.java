package lotto.domain;

import lotto.domain.generation.Number;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberTest {

    @Test(expected = IllegalArgumentException.class)
    public void checkValid_Out_Of_Range() {
        Number.checkValid(46);
    }

    @Test
    public void equals() {
        boolean areEqual = new Number(1).equals(new Number(1));
        assertEquals(true, areEqual);
    }
}