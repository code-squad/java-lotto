import LottoGame.WinningLotto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by hongjong-wan on 2018. 4. 11..
 */
public class WinningLottoTest {

    /**
     * 테스트 케이스 정리
     * 1. 매치 카운트 확인
     * 2. 보너스 번호 매치확인
     */
    @Test
    public void 매치카운트확인() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", 7);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(11);
        numbers.add(12);
        numbers.add(13);
        numbers.add(14);

        assertEquals(2, winningLotto.getMatchCount(numbers));
    }

    @Test
    public void 보너스번호매치확인() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", 7);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(11);
        numbers.add(12);
        numbers.add(13);
        numbers.add(14);

        assertEquals(false, winningLotto.matchBonus(numbers));
    }
}