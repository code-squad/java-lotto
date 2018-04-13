package lotto;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrizeTest {

    @Test
    public void 로또가_6개가_맞았을때_1등을_반환() {
        Prize prize = Prize.findPrize(6);
        assertEquals(Prize.FIRST, prize);
    }
}