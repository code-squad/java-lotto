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
        Lotto winningLotto = Lotto.of(Arrays.asList(1, 2, 3, 7, 8, 9));
        assertThat(3, is(lotto.getNumOfMatched(winningLotto)));
    }

    @Test
    public void 로또문자열변환() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = Lotto.of(numbers);
        assertThat("1,2,3,4,5,6", is(lotto.toString()));
    }

    @Test
    public void 보너스유무확인_true(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 10);
        Lotto lotto = Lotto.of(numbers);
        WinningLotto winningLotto = WinningLotto.of(Arrays.asList(1, 2, 3, 4, 5, 6), Number.of(10));
        assertThat(lotto.isBonus(winningLotto), is(true));
    }

    @Test
    public void 보너스유무확인_false(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = Lotto.of(numbers);
        WinningLotto winningLotto = WinningLotto.of(Arrays.asList(1, 2, 3, 4, 5, 6), Number.of(10));
        assertThat(lotto.isBonus(winningLotto), is(false));
    }

    @Test
    public void 등수확인_FIRST(){
        Lotto lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = WinningLotto.of(Arrays.asList(1, 2, 3, 4, 5, 6), Number.of(5));
        assertThat(lotto.getRank(winningLotto), is(Rank.FIRST));
    }
}
