package domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
public class UserTest {

    @Test
    public void 돈입력유효값확인_true() {
        assertThat(User.isValidMoney(1000), is(true));
    }

    @Test
    public void 돈입력유효값확인_false() {
        assertThat(User.isValidMoney(0), is(false));
        assertThat(User.isValidMoney(100), is(false));
    }

    @Test
    public void 자동로또유효갯수체크_true() {
        assertThat(User.isValidNumTickets(0), is(true));
    }

    @Test
    public void 자동로또유효갯수체크_false() {
        assertThat(User.isValidNumTickets(-1), is(false));
    }

    @Test
    public void 수익률계산() {
        User user = User.whoHasMoneyOf(5000);
        user.purchaseTicketsAuto(5);
        assertThat(user.calcProfit(), is(0));
    }
}
