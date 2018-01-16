package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TicketTest {
    Ticket ticket;
    @Before
    public void init() {
        ticket = new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6));
    }
    @Test
    public void createTicketTest() {
        Ticket ticket = new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(ticket.getNums()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void createLottoTest() {
        Lotto lotto = ticket.createLotto();
        assertThat(lotto).isEqualTo(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6)));
    }
}
