package domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
public class UserTest {

    @Test
    public void 자동로또유효갯수체크_true() {
        assertThat(User.isValidNumTickets(0), is(true));
    }

    @Test
    public void 자동로또유효갯수체크_false() {
        assertThat(User.isValidNumTickets(-1), is(false));
    }

}
