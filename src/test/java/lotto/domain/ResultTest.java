package lotto.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class ResultTest {

    @Test
    public void calculatePrize() {
        Result result = new Result(Match.FOURTH, 2);
        assertEquals(100000, result.calculatePrize());
    }
}