import lottoGame.domain.Lotto;
import lottoGame.domain.LottoGame;
import lottoGame.domain.WinningLotto;
import lottoGame.enums.Rank;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class LottoGameTest {

    private LottoGame lottoGame;

    @Before
    public void setup() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1,2,3,4,5,6)));
        lottos.add(new Lotto(Arrays.asList(1,3,4,5,6,7)));


        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1,2,3,4,5,8),6);

        lottoGame = new LottoGame(2000,lottos);

        lottoGame.runGame(winningLotto);
    }

    @Test
    public void 로또_게임_통계_테스트() {
        assertEquals(1,lottoGame.getRankCount(Rank.SECOND));
        assertEquals(1,lottoGame.getRankCount(Rank.FOURTH));

    }

    @Test
    public void 로또_수익률_계산() {
        assertEquals(1502500,lottoGame.calcProfit());
    }
}
