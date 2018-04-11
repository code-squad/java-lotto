import LottoGame.Lotto;
import LottoGame.Lottos;
import LottoGame.Rank;
import LottoGame.WinningLotto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by hongjong-wan on 2018. 4. 8..
 */
public class LottosTest {
    /**
     * 테스트 케이스 정리
     * 1. 랭킹확인
     */

    @Test
    public void 랭킹확인() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            numbers.add(i);
        }
        Lottos lottos = new Lottos();
        lottos.add(new Lotto(numbers));

        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,14", 7);
        assertEquals(Rank.THIRD, lottos.getRanks(winningLotto).get(0));
    }
}