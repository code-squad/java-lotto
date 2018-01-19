package model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    private Lotto lotto;

    @Before
    public void setup() {
        lotto = new Lotto();
    }

    @Test
    public void generateTest() {
        String lottoString = lotto.toString();

        assertThat(lottoString.length()).isGreaterThanOrEqualTo(18);
    }

    @Test
    public void compareTest() {
        Lotto lotto1 = new Lotto("1,2,3,4,5,6".split(","));
        Lotto lotto2 = new Lotto("1,2,3,4,5,7".split(","));
        Lotto lotto3 = new Lotto("1,2,3,4,7,8".split(","));

        WinningLotto winningLotto = new WinningLotto(new Lotto("1,2,3,4,5,6".split(",")),27);

        assertThat(winningLotto.compare(lotto1)).isEqualTo(ResultTypes.findByCode(6));
        assertThat(winningLotto.compare(lotto2)).isEqualTo(ResultTypes.findByCode(5));
        assertThat(winningLotto.compare(lotto3)).isEqualTo(ResultTypes.findByCode(4));
    }

    @Test
    public void compareBonusTest() {
        Lotto lotto = new Lotto("1,2,3,4,5,27".split(","));

        WinningLotto winningLotto = new WinningLotto(new Lotto("1,2,3,4,5,6".split(",")),27);
        assertThat(winningLotto.compare(lotto)).isEqualTo(ResultTypes.findByCode(5,true));
    }
}
