package lotto;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrizeTest {

    @Test
    public void 로또가_6개가_맞았을때_1등을_반환() {
        Prize prize = Prize.findPrize(6, false);
        assertEquals(Prize.FIRST, prize);
    }

    @Test
    public void 로또가_5개가_맞았고_보너스번호까지_맞으면_2등을_반환() {
        Prize prize = Prize.findPrize(5, true);
        assertEquals(Prize.SECOND, prize);
    }

    @Test
    public void 로또가_5개가_맞았고_보너스번호가_안맞으면_3등을_반환() {
        Prize prize = Prize.findPrize(5, false);
        assertEquals(Prize.THIRD, prize);
    }

    @Test
    public void 로또가_4개가_맞으면_4등을_반환() {
        Prize prize = Prize.findPrize(4, false);
        assertEquals(Prize.FOURTH, prize);
    }

    @Test
    public void 로또가_4개가_맞고_보너스번호까지_맞으면_4등을_반환() {
        Prize prize = Prize.findPrize(4, true);
        assertEquals(Prize.FOURTH, prize);
    }
}