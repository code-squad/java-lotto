package lotto.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberTest {

    @Test
    public void equals() {
        boolean areEqual = new Number(1).equals(new Number(1));
        assertEquals(true, areEqual);
    }


}