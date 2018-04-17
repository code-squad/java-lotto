package lotto;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    LottoMachine lottoMachine;

    @Before
    public void setup() {
        lottoMachine = new LottoMachine(3000);
    }

    @Test
    public void 로또_구매() {
        int result = lottoMachine.getCountOfLotto();
        assertThat(result).isEqualTo(3);
    }
    @Test
    public void 로또_매치() {
        List<LottoNumbers> myLottos = new ArrayList<LottoNumbers>();
        myLottos.add(new LottoNumbers(Arrays.asList(1, 2, 3, 7, 8, 9))); // 3개 일치
        myLottos.add(new LottoNumbers(Arrays.asList(1, 2, 3, 8, 10, 20))); // 3개 일치
        myLottos.add(new LottoNumbers(Arrays.asList(1, 2, 3, 9, 10, 30))); // 3개 일치
        LottoNumbers winLotto = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));

        int actual = lottoMachine.calculate(myLottos, winLotto).getMatchCount(3);
        int expected = 3;
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void 수익률_계산() {
        int[] matchCount = {0, 0, 0, 1, 0, 0, 0};
        int rate = (int) lottoMachine.getRateOfInvestment(matchCount);
        assertThat(rate).isEqualTo(166);
    }
}
