import lotto.Lotto;
import lotto.LottoGame;
import org.junit.Test;
import rank.Rank;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGameTest {
    @Test
    public void 맞춘갯수빼오기() {
        LottoGame game = new LottoGame();
        List<Integer> counts = new ArrayList<>();
        counts.add(3);
        counts.add(4);
        counts.add(5);
        counts.add(3);
        int num1 = game.getCount(counts, 3);
        int num2 = game.getCount(counts, 4);
        int num3 = game.getCount(counts, 5);
        assertEquals(2, num1);
        assertEquals(1, num2);
        assertEquals(1, num3);
    }

    @Test
    public void 당첨번호갯수불러오기() {
        LottoGame game = new LottoGame();
        List<Integer> counts = Arrays.asList(1,3,3,4,5);
        List<Integer> winCounts = game.getWinCounts(counts);
        int num1 = winCounts.get(0);
        int num2 = winCounts.get(1);
        int num3 = winCounts.get(2);
        assertEquals(2, num1);
        assertEquals(1, num2);
        assertEquals(1, num3);
    }

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
