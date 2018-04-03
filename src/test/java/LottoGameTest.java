import lotto.Lotto;
import lotto.LottoGame;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGameTest {
    @Test
    public void 숫자비교() {
        LottoGame game = new LottoGame();
        List<Lotto> lottos = Arrays.asList(new Lotto("1,2,3,4,7,8"), new Lotto("1,2,3,11,22,33"), new Lotto("17,29,31,11,22,33"));
        Lotto winningNumber = new Lotto("1,2,3,4,5,6");
        List<Integer> counts = game.match(lottos, winningNumber);
        int compare1 = counts.get(0);
        int compare2 = counts.get(1);
        int compare3 = counts.get(2);
        assertEquals(4, compare1);
        assertEquals(3, compare2);
        assertEquals(0, compare3);
    }

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
}
