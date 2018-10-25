package domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnigLottoTest {

    private WinningLotto winningLotto;
    private Lotto lotto;
    private Lotto lotto2;

    @Before
    public void setUp() {
        List<LottoNum> lottos = new ArrayList<>();
        List<LottoNum> lottos2 = new ArrayList<>();
        for(int i = 1; i <= Lotto.LOTTO_NUMBER_COUNT; i++) {
            lottos.add(new LottoNum(i));
            lottos2.add(new LottoNum(i * 2));

        }
        winningLotto = new WinningLotto(lottos, new LottoNum(8));
        lotto = new Lotto(lottos);
        lotto2 = new Lotto(lottos2);
    }

    @Test(expected = InputMismatchException.class)
    public void isDuplicationTest() {
        assertThat(winningLotto.isDuplicationBonusNumber(new LottoNum(1))).isTrue();
    }

    @Test
    public void obtainRewardTest() {
        LottoNum[] lottos = {
          new LottoNum(1), new LottoNum(2), new LottoNum(3),
          new LottoNum(4), new LottoNum(5), new LottoNum(6)
        };
        assertThat(winningLotto.obtainReward(lotto)).isEqualTo(Reward.FIRST_REWARD);
    }

    @Test
    public void isBonusHitTest() {
        assertThat(winningLotto.isBonusHit(lotto2)).isTrue();
    }
}
