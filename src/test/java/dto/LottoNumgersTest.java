package dto;

import domain.lotto.LottoNumber;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LottoNumgersTest {

    LottoNumbers numbers;

    @Before
    public void init(){
        numbers = LottoNumbers.of("1, 2, 3, 4, 5, 6");
    }

    @Test
    public void isHitNumber_hit() {
        assertThat(numbers.isHitNumber(LottoNumber.of(1)), is(1));
    }

    @Test
    public void isHitNumber_none_hit() {
        assertThat(numbers.isHitNumber(LottoNumber.of(7)), is(0));
    }
}
