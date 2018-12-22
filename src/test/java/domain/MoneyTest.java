package domain;

import org.junit.Before;
import org.junit.Test;
import support.Fixture;

import java.util.Map;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class MoneyTest extends Fixture {
    Money money;

    @Before
    public void setUp() throws Exception {
        money = new Money(5000);
    }

    @Test
    public void getCountTest() {
        assertThat(money.getCount()).isEqualTo(5);
    }

    @Test
    public void calculateRatioTest() {
        Map<Integer, Integer> result = RESULT;
        result.put(4,1);

        assertThat(money.calculateRatio(result)).isEqualTo(1000);
    }
}