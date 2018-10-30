package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.IntegerToLottoNum.convertLottoNums;

public class LottoTest {
    Lotto userLotto;
    Lotto winningLotto;

    @Before
    public void setUp() throws Exception {
        userLotto = new Lotto(convertLottoNums(Arrays.asList(6, 7, 45, 2, 9, 14)));
        winningLotto = new Lotto(convertLottoNums(Arrays.asList(30, 7, 32, 12, 45, 6)));
    }

    @Test
    public void isStrike() {
        assertThat(userLotto.strikeCheck(winningLotto)).isEqualTo(3);
    }

    @Test
    public void addStrikePoint() {
        assertThat(userLotto.addStrikePoint(true)).isEqualTo(1);
        assertThat(userLotto.addStrikePoint(false)).isEqualTo(0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void isDuplicated() {
        Lotto duplicatedLotto = new Lotto(convertLottoNums(Arrays.asList(1, 1, 3, 2, 5, 6)));
    }

    @Test (expected = IllegalArgumentException.class)
    public void isLottoSize() {
        Lotto overSizeLotto = new Lotto(convertLottoNums(Arrays.asList(1, 2, 7, 3, 2, 5, 6)));
    }

    @Test (expected = IllegalArgumentException.class)
    public void isNotInRange() {
        Lotto outRangeLotto = new Lotto(convertLottoNums(Arrays.asList(1, 2, 47, 22, 5, 6)));
    }

    @Test
    public void 몇개_동일한_원소_가지나1() {
        assertThat(userLotto.strikeCheck(winningLotto)).isEqualTo(3);
    }

    @Test
    public void 몇개_동일한_원소_가지나2() {
        userLotto = new Lotto(convertLottoNums(Arrays.asList(6, 7, 45, 2, 9, 30)));
        assertThat(userLotto.strikeCheck(winningLotto)).isEqualTo(4);
    }
}