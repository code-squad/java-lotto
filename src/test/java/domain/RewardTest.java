package domain;

import domaim.Lotto;
import domaim.LottoNum;
import domaim.Reward;
import org.junit.Test;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;


public class RewardTest {

    @Test
    public void matchLottoTest() {
        LottoNum[] arr = {
                new LottoNum(1),
                new LottoNum(2),
                new LottoNum(3),
                new LottoNum(4),
                new LottoNum(5),
                new LottoNum(6)
        };
        List<LottoNum> lotto = new ArrayList<LottoNum>(Arrays.asList(arr));
        List<LottoNum> reward = new ArrayList<>(Arrays.asList(arr));
        assertThat(new Reward(new Lotto(lotto)).matchLotto(new Lotto(lotto))).isEqualTo(6);
    }
}
