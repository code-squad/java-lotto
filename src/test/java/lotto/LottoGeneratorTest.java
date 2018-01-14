package lotto;

import lotto.domain.LottoConstants;
import org.junit.Test;

import static org.junit.Assert.*;

public class LottoGeneratorTest {
    @Test
    public void randomNumbers() throws Exception {
        assertEquals(LottoConstants.NUMBER_COUNT, LottoGenerator.randomNumbers().size());
    }

}