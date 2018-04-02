package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TicketTest {
    private List<Number> numbers;

    @Before
    public void setUp() throws Exception {
        numbers = Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6));
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkValid_Throw_Exception_Size_Is_Not_6() {
        numbers = new ArrayList<>(numbers);
        numbers.add(new Number(7)); //over 6
        Ticket.checkValid(numbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkValid_Throw_Exception_Duplicate_Number() {
        numbers.set(0, new Number(2)); //duplicate
        Ticket.checkValid(numbers);
    }

    @Test
    public void contains() {
        Ticket ticket = new Ticket(numbers);
        assertThat(ticket.contains(new Number(6))).isEqualTo(true);
    }
}