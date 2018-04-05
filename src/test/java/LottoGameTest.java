import lotto.Lotto;
import lotto.LottoGame;
import lotto.WinningLotto;
import org.junit.Test;
import rank.Rank;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;

public class LottoGameTest {
    @Test
    public void SECOND등수매기기() {
        List<Lotto> lottos = Arrays.asList(new Lotto("1,2,3,4,5,7"), new Lotto("1,2,3,4,5"), new Lotto("1,2,3,4,5,6"));
        Lotto winningLotto = new Lotto("1,2,3,4,5,6");
        int bonusNumber = 7;
        LottoGame game = new LottoGame(lottos);
        WinningLotto winLotto = new WinningLotto(winningLotto, bonusNumber);
        assertEquals(Rank.SECOND ,game.decision(lottos.get(0), winLotto));
    }

    @Test
    public void THIRD등수매기기() {
        List<Lotto> lottos = Arrays.asList(new Lotto("1,2,3,4,5,7"), new Lotto("1,2,3,4,5"), new Lotto("1,2,3,4,5,6"));
        Lotto winningLotto = new Lotto("1,2,3,4,5,6");
        int bonusNumber = 7;
        WinningLotto winLotto = new WinningLotto(winningLotto, bonusNumber);
        LottoGame game = new LottoGame(lottos);
        assertEquals(Rank.THIRD ,game.decision(lottos.get(1), winLotto));
    }

    @Test
    public void FIRST등수매기기() {
        List<Lotto> lottos = Arrays.asList(new Lotto("1,2,3,4,5,7"), new Lotto("1,2,3,4,5"), new Lotto("1,2,3,4,5,6"));
        Lotto winningLotto = new Lotto("1,2,3,4,5,6");
        int bonusNumber = 7;
        WinningLotto winLotto = new WinningLotto(winningLotto, bonusNumber);
        LottoGame game = new LottoGame(lottos);
        assertEquals(Rank.FIRST ,game.decision(lottos.get(2), winLotto));
    }

    @Test
    public void 랭크리스트() {
        List<Lotto> lottos = Arrays.asList(new Lotto("11,22,33,44,55,66"), new Lotto("1,2,3,4,5,7"), new Lotto("1,2,3,4,5,6"));
        Lotto winningLotto = new Lotto("1,2,3,4,5,6");
        int bonusNumber = 7;
        WinningLotto winLotto = new WinningLotto(winningLotto, bonusNumber);
        LottoGame game = new LottoGame(lottos);
        List<Rank> ranks = Arrays.asList(Rank.NONE, Rank.SECOND, Rank.FIRST);
        assertEquals(ranks.get(0), game.match(winLotto).getRanks().get(0));
        assertEquals(ranks.get(1), game.match(winLotto).getRanks().get(1));
        assertEquals(ranks.get(2), game.match(winLotto).getRanks().get(2));
    }

    @Test
    public void 매치테스트() {
        List<Lotto> lottos = Arrays.asList(new Lotto("1,2,3,4,5,6"), new Lotto("1,2,3,7,8,9"));
        Lotto winningLotto = new Lotto("1,2,3,4,5,6");
        int bonusNumber = 7;
        LottoGame game = new LottoGame(lottos);
        WinningLotto lotto = new WinningLotto(winningLotto, bonusNumber);
        game.match(lotto);
    }
}
