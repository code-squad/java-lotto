package DTO;

import domain.lotto.LottoNumber;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LottoNumgersTest {

    @Test
    public void isHitNumber_hit() {
        List<LottoNumber> number1 = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)

        );
        LottoNumbers numbers = new LottoNumbers(number1);

        assertThat(numbers.isHitNumber(new LottoNumber(1)), is(1));
    }

    @Test
    public void isHitNumber_none_hit() {
        List<LottoNumber> number1 = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)

        );
        LottoNumbers numbers = new LottoNumbers(number1);

        assertThat(numbers.isHitNumber(new LottoNumber(7)), is(0));
    }
}
