package lotto;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Joeylee on 2018-01-13.
 */

public class LottoMachineTest {

    private LottoMachine lottoMachine;

    @Before
    public void setUp() throws Exception {
        lottoMachine  = new LottoMachine();
    }

    @Test
    public void 구입금액에_따라_구매가능한_로또개수_출력() throws Exception {
        int count = lottoMachine.countForPrice(3000);

        assertEquals(3, count);
    }


    @Test
    public void 랜덤_숫자들_가져오기() throws Exception {
        List<Integer> numbers = lottoMachine.getRandomNumbers();

        System.out.println(numbers);
    }

    @Test
    public void 구입한_로또_출력() throws Exception {
        List<Lotto> lottos = lottoMachine.createRandomLotto(5);

        for (Lotto lotto : lottos) {
            lotto.printLotto();
        }
    }

    @Test
    public void 당첨번호와_맞은_개수_파악하기() throws Exception {
        List<Lotto> lottos = lottoMachine.createRandomLotto(5);
        List<Integer> matchingNumbers = new ArrayList<>();
        matchingNumbers.add(1);
        matchingNumbers.add(3);
        matchingNumbers.add(5);
        matchingNumbers.add(6);
        matchingNumbers.add(10);
        matchingNumbers.add(11);

        Map<Integer, Integer> result = lottoMachine.makeResult(matchingNumbers);

        for (Lotto lotto : lottos) {
            lotto.printLotto();
            System.out.println(lotto.countMatchingAnswer(matchingNumbers));
        }


    }
}