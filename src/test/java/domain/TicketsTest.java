package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class TicketsTest {
    private Tickets tickets;

    @Before
    public void init() {
        List<Ticket> ticket = new ArrayList<>();
        ticket.add(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6)));
        ticket.add(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 7)));
        ticket.add(new Ticket(Arrays.asList(1, 2, 3, 4, 7, 8)));
        ticket.add(new Ticket(Arrays.asList(1, 2, 3, 7, 8, 9)));

        tickets = new Tickets(ticket);
    }
    @Test
    public void ticketsTest() {
        assertThat(tickets.getTickets().get(0).getNums()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void createLottosTest() {
        List<Lotto> lottos = new ArrayList<>();
        tickets.createLottos(lottos);

        List<Lotto> expectedLottos = new ArrayList<>();
        expectedLottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6)));
        expectedLottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 7)));
        expectedLottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 7, 8)));
        expectedLottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 7, 8, 9)));

        assertThat(lottos).isEqualTo(expectedLottos);
    }
}
