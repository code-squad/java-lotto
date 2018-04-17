package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    Lotto lotto;

    @Before
    public void setup() {
        lotto = Lotto.of(Arrays.asList(1,2,3,4,5,6));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 당첨번호_안에_보너스번호_존재() {
        WinningLotto winningLotto = new WinningLotto(lotto, LottoNumber.of(6));
    }

    @Test
    public void 당첨번호_번호_포함() {
        WinningLotto winningLotto = new WinningLotto(lotto, LottoNumber.of(7));
        boolean result = winningLotto.contains(LottoNumber.of(1));
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void 당첨번호_번호_미포함() {
        WinningLotto winningLotto = new WinningLotto(lotto, LottoNumber.of(7));
        boolean result = winningLotto.contains(LottoNumber.of(45));
        assertThat(result).isEqualTo(false);
    }

    @Test
    public void 로또_안에_보너스번호_포함() {
        WinningLotto winningLotto = new WinningLotto(lotto, LottoNumber.of(7));
        List<Integer> testInts = Arrays.asList(1,2,3,4,5,7);
        List<LottoNumber> testLotto = testInts.stream()
                                              .map(LottoNumber::of)
                                              .collect(Collectors.toList());
        boolean result = winningLotto.matchBonusNumber(testLotto);
        assertThat(result).isEqualTo(true);
    }
}
