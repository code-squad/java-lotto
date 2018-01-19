package lotto.domain;

import org.junit.Before;

/**
 * Created by Moonchan on 2018. 1. 16..
 */
public class LottoTicketTest {

    private LottoTicket ticket;

    @Before
    public void setup() {
        ticket = new LottoTicket(new ManualLottoNumberGenerator(1, 2, 3, 4, 5, 6));
    }
}