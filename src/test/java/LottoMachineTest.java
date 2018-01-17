import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.domain.enums.Rank;
import lotto.domain.generator.CustomLottoNumberGenerator;
import lotto.view.Input;

import static java.util.Optional.of;
import static java.util.Optional.ofNullable;
import static lotto.domain.enums.Rank.FIVE;
import static lotto.domain.enums.Rank.FIVE_DOUBLE;
import static lotto.domain.enums.Rank.FOUR;
import static lotto.domain.enums.Rank.SIX;
import static lotto.domain.enums.Rank.THREE;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class LottoMachineTest {

    @Test
    public void 금액에_맞는_개수인가() {
        LottoMachine lottoMachine = LottoMachine.init(Input.init("14000").getMoney(), 3);
        assertEquals(11, lottoMachine.getRandomLottoCount());
        assertEquals(3, lottoMachine.getCustomLottoCount());
    }

    @Test
    public void 입력된_개수에_맞는_로또가_생성되는가() {
        LottoMachine lottoMachine = LottoMachine.init(Input.init("14000").getMoney(), 0);
        assertEquals(14, lottoMachine.generateLottos(new ArrayList<>()).getLottos().size());
    }

    @Test
    public void 당첨번호_통계결과가_일치하는가() {
        Map<Rank, Integer> resultMap = initResultMap("1, 2, 3, 4, 5, 6", 7);

        assertEquals(of(2).get(), ofNullable(resultMap.get(THREE)).orElse(0));
        assertEquals(of(0).get(), ofNullable(resultMap.get(FOUR)).orElse(0));
        assertEquals(of(1).get(), ofNullable(resultMap.get(FIVE)).orElse(0));
        assertEquals(of(1).get(), ofNullable(resultMap.get(FIVE_DOUBLE)).orElse(0));
        assertEquals(of(1).get(), ofNullable(resultMap.get(SIX)).orElse(0));
    }

    @Test
    public void 당첨되지_않으면_비어있는_값을_반환하는가() {
        assertTrue(initResultMap("21, 22, 23, 24, 25, 26", 17).isEmpty());
    }

    @Test
    public void 총수익이_올바른가() {
        assertEquals(2031510000, LottoResult.getProfit(initResultMap("1, 2, 3, 4, 5, 6", 7)));
    }

    @Test
    public void 총수익률이_올바른가() {
        assertThat(LottoResult.getProfitRate(LottoResult.getProfit(initResultMap("1, 2, 3, 4, 5, 6", 7)), 6000), is(3.38585E7F));
    }

    private Map<Rank, Integer> initResultMap(String stringWinNumbers, int bonusBall) {
        List<Lotto> testLottos = new ArrayList<>();
        testLottos.add(Lotto.generate(() -> Arrays.asList(1, 2, 3, 40, 41, 42))); //THREE
        testLottos.add(Lotto.generate(() -> Arrays.asList(1, 2, 3, 14, 15, 16))); //THREE
        testLottos.add(Lotto.generate(() -> Arrays.asList(1, 2, 3, 4, 5, 16))); //FIVE
        testLottos.add(Lotto.generate(() -> Arrays.asList(11, 2, 7, 4, 5, 6))); //FIVE_DOUBLE
        testLottos.add(Lotto.generate(() -> Arrays.asList(1, 2, 3, 4, 5, 6))); //SIX
        Lottos lottos =  Lottos.generate(testLottos);

        Lotto lotto = (Input.init(stringWinNumbers).winNumbers());
        WinningLotto winningLotto = WinningLotto.generate(lotto, bonusBall);
        return LottoResult.generate(lottos.getWinningRank(winningLotto)).getWinningLottoMap();
    }
}
