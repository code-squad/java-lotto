package lotto;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    LottoMachine lottoMachine;

    @Before
    public void setup() {
        lottoMachine = new LottoMachine();
    }

    @Test
    public void 로또_구매() {
        int result = lottoMachine.getCountOfLotto(13000);
        assertThat(result).isEqualTo(13);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 음수개_로또_구매() {
        int result = lottoMachine.getCountOfLotto(-1);
    }

    @Test
    public void 로또_매치() {
        List<Integer>[] myLottos = new List[3];
        myLottos[0] = Arrays.asList(1, 2, 3, 7, 8, 9); // 3개 일치
        myLottos[1] = Arrays.asList(1, 2, 3, 4, 10, 20); // 4개 일치
        myLottos[2] = Arrays.asList(1, 2, 3, 4, 5, 30); // 5개 일치
        List<Integer> winLotto = Arrays.asList(1, 2, 3, 4, 5, 6);

        int[] expected = lottoMachine.getMatchCounts(myLottos, winLotto);
        int[] actual = {0, 0, 0, 1, 1, 1, 0};
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void 수익률_계산() {
        int money = 15000;
        int[] matchCount = {0, 0, 0, 1, 0, 0, 0};
        int rate = (int) lottoMachine.getRateOfInvestment(money, matchCount);
        assertThat(rate).isEqualTo(33);
    }
}
