import model.Customer;
import model.HandOperatedLotto;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp(){
        customer = new Customer();
    }

    @Test
    public void buy(){
        String[] array = {};
        HandOperatedLotto handOperatedLotto = new HandOperatedLotto(0, array);
        assertThat(customer.buy(14000, handOperatedLotto).size()).isEqualTo(14);
    }

    @Test
    public void getLottoResult(){
        assertThat(customer.getLottoResult("1,2,3,4,5,6", 8).getLottoResult().size()).isEqualTo(5);
    }
}
