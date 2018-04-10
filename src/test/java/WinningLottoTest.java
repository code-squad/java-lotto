import LottoGame.WinningLotto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by hongjong-wan on 2018. 4. 11..
 */
public class WinningLottoTest {

    @Test
    public void 로또당첨번호생성() {
        List<Integer> winningNumbers = new ArrayList<>();
        winningNumbers.add(1);
        winningNumbers.add(2);
        winningNumbers.add(3);
        winningNumbers.add(4);
        winningNumbers.add(5);
        winningNumbers.add(6);

        assertEquals(winningNumbers, WinningLotto.createWinningLotto(new String[]{"1", "2", "3", "4", "5", "6"}));
    }
}
