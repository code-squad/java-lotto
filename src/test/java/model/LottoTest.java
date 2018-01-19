package model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private UserLotto lotto;

    @Before
    public void setup() {
        lotto = new UserLotto();
    }

    @Test
    public void generateTest() {
        String lottoString = lotto.toString();

        assertThat(lottoString.length()).isGreaterThanOrEqualTo(18);
    }

    @Test
    public void compareTest() {
        UserLotto lotto1 = new UserLotto(
                Stream.of(1, 2, 3, 4, 5, 6)
                    .map(LottoNumber::new)
                    .collect(Collectors.toList()));
        UserLotto lotto2 = new UserLotto(
                Stream.of(1, 2, 3, 4, 5, 7)
                    .map(LottoNumber::new)
                    .collect(Collectors.toList()));
        UserLotto lotto3 = new UserLotto(
                Stream.of(1, 2, 3, 4, 7, 8)
                    .map(LottoNumber::new)
                    .collect(Collectors.toList()));

        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 27);

        assertThat(winningLotto.compare(lotto1)).isEqualTo(ResultTypes.findByCode(6));
        assertThat(winningLotto.compare(lotto2)).isEqualTo(ResultTypes.findByCode(5));
        assertThat(winningLotto.compare(lotto3)).isEqualTo(ResultTypes.findByCode(4));
    }

    @Test
    public void compareBonusTest() {
        UserLotto lotto = new UserLotto(
                Stream.of(1, 2, 3, 4, 5, 27)
                    .map(LottoNumber::new)
                    .collect(Collectors.toList()));

        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 27);
        assertThat(winningLotto.compare(lotto)).isEqualTo(ResultTypes.findByCode(5, true));
    }
}
