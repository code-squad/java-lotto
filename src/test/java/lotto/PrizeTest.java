package lotto;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrizeTest {

    @Test
    public void 로또가_6개가_맞았을때_1등을_반환() {
        Prize prize = Prize.findPrize(6);
        assertEquals(Prize.FIRST, prize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_맞은_갯수가_상품을_받는_갯수보다_작을경우_예외발생() {
        Prize.findPrize(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_맞은_갯수가_상품을_받는_갯수보다_클경우_예외발생() {
        Prize.findPrize(7);
    }
}