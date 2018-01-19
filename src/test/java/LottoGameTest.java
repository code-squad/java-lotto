import lottoGame.domain.Lotto;
import lottoGame.domain.LottoGame;
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
        lottoGame = new LottoGame(2000,lottos);

    }

    @Test
    public void 로또_게임_실행결과_테스트() {
        Lotto lastWeekLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        List<Lotto> compareLottos = new ArrayList<>();

        compareLottos.add(new Lotto(Arrays.asList(1,2,3,4,5,6)));
        compareLottos.add(new Lotto(Arrays.asList(1,3,4,5,6,7)));

        for (Lotto compareLotto : compareLottos) {
            compareLotto.matchPoint(lastWeekLotto);
        }

        assertEquals(true,lottoGame.runGame(lastWeekLotto).equals(compareLottos));
    }
}
