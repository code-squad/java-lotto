import model.Customer;
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
        assertThat(customer.buy(14000).size()).isEqualTo(14);
    }

    @Test
    public void getLottoResult(){
        customer.buy(4000);

        assertThat(customer.getLottoResult("1,2,3,4,5,6", 8).getLottoResult().size()).isEqualTo(5);
    }
}
