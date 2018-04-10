package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersTest {
    private Numbers numbers;

    @Before
    public void setUp() throws Exception {
        numbers = new Numbers(1, 3, 5, 14, 22, 45);
    }

    @Test
    public void countMatch테스트() {
        assertThat(numbers.countMatch(new Numbers(1, 2, 3, 4, 5, 6))).isEqualTo(3);
        assertThat(numbers.countMatch(new Numbers(1, 2, 4, 5, 6, 44))).isEqualTo(2);
        assertThat(numbers.countMatch(new Numbers(5, 6, 44, 1, 2, 4))).isEqualTo(2);
    }

}
