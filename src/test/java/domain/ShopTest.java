package domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShopTest {

    @Test
    public void 낱개로또판매확인() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(Shop.sellTicket(numbers), is(Lotto.of(numbers)));
    }
}
