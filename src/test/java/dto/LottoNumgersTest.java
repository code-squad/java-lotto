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

    SortedSet<LottoNumber> number1;
    LottoNumbers numbers;

    @Before
    public void init(){
        number1 = new TreeSet<>();

        number1.add(new LottoNumber(1));
        number1.add(new LottoNumber(2));
        number1.add(new LottoNumber(3));
        number1.add(new LottoNumber(4));
        number1.add(new LottoNumber(5));
        number1.add(new LottoNumber(6));

        numbers = new LottoNumbers(number1);
    }

    @Test
    public void isHitNumber_hit() {
        assertThat(numbers.isHitNumber(new LottoNumber(1)), is(1));
    }

    @Test
    public void isHitNumber_none_hit() {
        assertThat(numbers.isHitNumber(new LottoNumber(7)), is(0));
    }
}
