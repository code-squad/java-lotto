package lotto.util;

import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class TicketNumberParserTest {
    @Test
    public void parse() throws Exception {
        List<Integer> lottoNumbers = TicketNumberParser.parse("1, 2, 3, 4, 5, 6");
        assertTrue(lottoNumbers.contains(1));
        assertTrue(lottoNumbers.contains(2));
        assertTrue(lottoNumbers.contains(3));
        assertTrue(lottoNumbers.contains(4));
        assertTrue(lottoNumbers.contains(5));
        assertTrue(lottoNumbers.contains(6));
    }

}