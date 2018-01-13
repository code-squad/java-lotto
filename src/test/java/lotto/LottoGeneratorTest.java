package lotto;

import org.junit.Test;

import static org.junit.Assert.*;

public class LottoGeneratorTest {
    @Test
    public void randomNumbers() throws Exception {
        assertEquals(6, LottoGenerator.randomNumbers().size());
    }

}