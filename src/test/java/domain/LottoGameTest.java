package domain;
import dto.LottoDto;
import dto.RewardDto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @Test
    public void matchLottoResultTest() {
        List<LottoNum> lotto = new ArrayList<>();
        lotto.add(new LottoNum(1)); lotto.add(new LottoNum(2)); lotto.add(new LottoNum(3));
        lotto.add(new LottoNum(4)); lotto.add(new LottoNum(5)); lotto.add(new LottoNum(6));
        Lotto myLotto = new Lotto(lotto);

        List<LottoNum> winngig = new ArrayList<>();
        winngig.add(new LottoNum(2)); winngig.add(new LottoNum(3)); winngig.add(new LottoNum(4));
        winngig.add(new LottoNum(5)); winngig.add(new LottoNum(6)); winngig.add(new LottoNum(7));
        WinningLotto winningLotto = new WinningLotto(winngig, new LottoNum(1));
        assertThat(LottoGame.matchLottoResult(myLotto, winningLotto)).isEqualTo(Reward.SECOND_REWARD);
    }
}
