package lotto;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
        int count = lottoMachine.countForPrice(new Money(3000));

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
            System.out.println(lotto.toString());
        }
    }

    @Test
    public void 당첨번호와_맞은_개수_파악하기() throws Exception {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1,3,4,11,12,13)));
        lottos.add(new Lotto(Arrays.asList(1,3,4,5,12,13)));
        lottos.add(new Lotto(Arrays.asList(1,3,4,5,6,13)));
        lottos.add(new Lotto(Arrays.asList(1,3,4,5,6,8)));
        lottos.add(new Lotto(Arrays.asList(1,3,4,5,6,7)));
        lottoMachine.setLottos(lottos);
        List<Integer> matchingNumbers = Arrays.asList(1,3,4,5,6,7);
        Lotto matchingLotto = new Lotto(matchingNumbers);
        WinningLotto winningLotto = new WinningLotto(matchingLotto, 8);

        Result result = lottoMachine.makeResult(winningLotto);
        System.out.println(result.toString());

    }
}