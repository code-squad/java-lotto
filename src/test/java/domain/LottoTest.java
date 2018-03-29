package domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LottoTest {

    @Test
    public void 맞춘숫자갯수반환() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = Lotto.of(numbers);
        List<Integer> answer =  Arrays.asList(1, 2, 3, 7, 8, 9);
        assertThat(3, is(lotto.getNumOfMatches(answer)));
    }

    @Test
    public void 로또문자열변환() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = Lotto.of(numbers);
        assertThat("1,2,3,4,5,6", is(lotto.toString()));
    }

}
