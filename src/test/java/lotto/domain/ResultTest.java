package lotto.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class ResultTest {
    Result result;

    @Test
    public void calculatePrize() {
        result = new Result(Match.FOURTH, 2);
        assertEquals(100000, result.calculatePrize());
    }
}