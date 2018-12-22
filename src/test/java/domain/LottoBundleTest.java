package domain;

import org.junit.Test;
import support.Fixture;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LottoBundleTest extends Fixture {
    @Test
    public void checkWinTest() {
        Lotto winnerLotto = Lotto.of("1,2,3,4,5,6");
        LottoBundle lottoBundle = new LottoBundle(LOTTOBUNDLE);

        assertThat(lottoBundle.checkWin(winnerLotto).getResult().get(6)).isEqualTo(1);
        assertThat(lottoBundle.checkWin(winnerLotto).getResult().get(5)).isEqualTo(1);
        assertThat(lottoBundle.checkWin(winnerLotto).getResult().get(4)).isEqualTo(1);
        assertThat(lottoBundle.checkWin(winnerLotto).getResult().get(3)).isEqualTo(0);
    }
}