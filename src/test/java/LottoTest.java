import LottoGame.Lotto;
import LottoGame.WinningLotto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by hongjong-wan on 2018. 4. 7..
 */
public class LottoTest {
    /**
     * 테스트 케이스 정리
     * 1. 로또6개번호선택
     */

    @Test
    public void 로또6개번호선택() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        assertEquals(6, Lotto.chooseSixNumber(numbers).size());
    }

    @Test
    public void 일치하는개수() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            numbers.add(i);
        }
        Lotto lotto = new Lotto(numbers);
        assertEquals(6, lotto.getMatchCount(winningLotto));
    }
}
