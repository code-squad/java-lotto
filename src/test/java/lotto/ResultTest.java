package lotto;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
/**
 * Created by Joeylee on 2018-01-16.
 */
public class ResultTest {

    private Result result;
    private LottoMachine lottoMachine;

    @Before
    public void setUp() throws Exception {
        lottoMachine = new LottoMachine();
        result  = new Result();
    }

    @Test
    public void 로또맞은개수별_카운트() throws Exception {
        Lotto lotto = new Lotto(Arrays.asList(1,3,4,6,7,8));
        WinningLotto winningLotto = lottoMachine.createWinningLotto(new Lotto(Arrays.asList(1,2,3,4,5,6)), 8);
        result.addLottoResult(winningLotto.getRankmatchCountAndMatchBonus(lotto));
        assertEquals(new Integer(1), (result.getLottoResult().get(Rank.FOURTH)));
    }

    @Test
    public void 수익률_계산() throws Exception {
        Lotto lotto = new Lotto(Arrays.asList(1,3,4,6,7,8));
        WinningLotto winningLotto = lottoMachine.createWinningLotto(new Lotto(Arrays.asList(1,2,3,4,5,6)), 8);
        result.addLottoResult(winningLotto.getRankmatchCountAndMatchBonus(lotto));
        assertEquals(4900, result.rateTotal(1000));

    }
}