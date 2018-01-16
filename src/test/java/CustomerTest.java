import customer.Customer;
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
    public void getHitNumbers(){
        customer.buy(14000);
        assertThat(customer.getHitNumbers("1,2,3,4,5,6").size()).isEqualTo(14);
    }

    @Test
    public void analyze(){
        customer.buy(14000);
        assertThat(customer.analyze(customer.getHitNumbers("1,2,3,4,5,6"))).isBetween(-100.0, 100.0);
    }

    @Test
    public void countHit(){
        assertThat(customer.countHit(customer.getHitNumbers("1,2,3,4,5,6")));
    }
}
