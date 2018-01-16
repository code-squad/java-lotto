package domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TicketTest {
    @Test
    public void createTicketTest() {
        Ticket ticket = new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(ticket.getNums()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }
}
