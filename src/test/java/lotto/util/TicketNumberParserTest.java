package lotto.util;

import lotto.domain.LottoNumber;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class TicketNumberParserTest {
    @Test
    public void parse() throws Exception {
        List<LottoNumber> lottoNumbers = TicketNumberParser.parse("1, 2, 3, 4, 5, 6");
        assertTrue(lottoNumbers.contains(LottoNumber.newInstance(1)));
        assertTrue(lottoNumbers.contains(LottoNumber.newInstance(2)));
        assertTrue(lottoNumbers.contains(LottoNumber.newInstance(3)));
        assertTrue(lottoNumbers.contains(LottoNumber.newInstance(4)));
        assertTrue(lottoNumbers.contains(LottoNumber.newInstance(5)));
        assertTrue(lottoNumbers.contains(LottoNumber.newInstance(6)));
    }

}