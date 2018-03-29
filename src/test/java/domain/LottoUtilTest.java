package domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LottoUtilTest {

    @Test
    public void 로또갯수반환() {
        assertThat(14, is(LottoUtil.getNumOfLotto(14000)));
    }

    @Test
    public void 랜덤값리스트생성() {
        assertThat(6, is(LottoUtil.getRandNumbers().size()));
    }

    @Test
    public void 맞춘숫자갯수반환() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        List<Integer> answer =  Arrays.asList(1, 2, 3, 7, 8, 9);
        assertThat(3, is(lotto.getNumOfMatches(answer)));
    }



}
