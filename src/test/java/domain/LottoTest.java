package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LottoTest {
    List<Integer> numbers;

    @Before
    public void setup() {
        numbers = Arrays.asList(1,2,3,4,5,6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isValid() {
        LottoTicket lottoTicket = new LottoTicket(LottoNo.getLottoNos(numbers));
        lottoTicket.isValid(LottoNo.getLottoNos(Arrays.asList(1,2,3,4,5)));
    }

    @Test
    public void contains() {
        LottoTicket LottoTicket = new LottoTicket(LottoNo.getLottoNos(numbers));
        assertEquals(true, LottoTicket.contains(new LottoNo(1)));
    }
}
