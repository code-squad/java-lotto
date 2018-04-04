import lotto.Lotto;
import lotto.LottoGame;
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
        LottoGame game = new LottoGame();
        assertEquals(Rank.SECOND ,game.decision(lottos.get(0), winningLotto, bonusNumber));
    }

    @Test
    public void THIRD등수매기기() {
        List<Lotto> lottos = Arrays.asList(new Lotto("1,2,3,4,5,7"), new Lotto("1,2,3,4,5"), new Lotto("1,2,3,4,5,6"));
        Lotto winningLotto = new Lotto("1,2,3,4,5,6");
        int bonusNumber = 7;
        LottoGame game = new LottoGame();
        assertEquals(Rank.THIRD ,game.decision(lottos.get(1), winningLotto, bonusNumber));
    }

    @Test
    public void FIRST등수매기기() {
        List<Lotto> lottos = Arrays.asList(new Lotto("1,2,3,4,5,7"), new Lotto("1,2,3,4,5"), new Lotto("1,2,3,4,5,6"));
        Lotto winningLotto = new Lotto("1,2,3,4,5,6");
        int bonusNumber = 7;
        LottoGame game = new LottoGame();
        assertEquals(Rank.FIRST ,game.decision(lottos.get(2), winningLotto, bonusNumber));
    }

    @Test
    public void 랭크리스트() {
        List<Lotto> lottos = Arrays.asList(new Lotto("11,22,33,44,55,66"), new Lotto("1,2,3,4,5,7"), new Lotto("1,2,3,4,5,6"));
        Lotto winningLotto = new Lotto("1,2,3,4,5,6");
        int bonusNumber = 7;
        LottoGame game = new LottoGame();
        List<Rank> ranks = Arrays.asList(Rank.NONE, Rank.SECOND, Rank.FIRST);
        assertEquals(ranks.get(0), game.match(lottos, winningLotto, bonusNumber).get(0));
        assertEquals(ranks.get(1), game.match(lottos, winningLotto, bonusNumber).get(1));
        assertEquals(ranks.get(2), game.match(lottos, winningLotto, bonusNumber).get(2));
    }

}
