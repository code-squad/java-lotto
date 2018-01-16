package domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class TicketsTest {
    @Test
    public void ticketsTest() {
        List<Ticket> ticket = new ArrayList<>();
        ticket.add(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6)));
        ticket.add(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 7)));
        ticket.add(new Ticket(Arrays.asList(1, 2, 3, 4, 7, 8)));
        ticket.add(new Ticket(Arrays.asList(1, 2, 3, 7, 8, 9)));

        Tickets tickets = new Tickets(ticket);

        assertThat(tickets.getTickets().get(0).getNums()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }
}
