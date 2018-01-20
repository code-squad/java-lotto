package lotto.domain;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {

    @Test(expected = IllegalArgumentException.class)
    public void create_numbers_length() {
        new Lotto(Arrays.asList(1,2,3,4,5));

    }

    @Test(expected = IllegalArgumentException.class)
    public void create_numbers_range_unber() {
        new Lotto(Arrays.asList(1,2,3,4,5,60));

    }

    @Test(expected = IllegalArgumentException.class)
    public void create_numbers_range_over() {
        new Lotto(Arrays.asList(0,2,3,4,5,45));

    }

    @Test
    public void contains() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));

        assertThat(lotto.contains(1)).isTrue();
        assertThat(lotto.contains(7)).isFalse();
    }
}