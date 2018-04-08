package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;

public class LottoTicketIssuerTest {
    @Test
    public void 번호_6개를_가진_로또_티켓을_발행한다() {
        //given
        LottoTicket ticket;

        //when
        ticket = LottoTicketIssuer.issue();

        //then
        Assertions.assertThat(ticket.getNumbers()).hasSize(6);
    }

    @Test
    public void 여러_티켓을_한번에_발행가능하다() {
        //given
        int money = 5_000;
        int purchasableTicketCount = LottoTicketIssuer.getPurchasableTicketCount(money);

        //when
        List<LottoTicket> tickets = LottoTicketIssuer.issue(money);

        //then
        Assertions.assertThat(tickets).hasSize(purchasableTicketCount);
    }
}