import lotto.domain.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.domain.enums.LottoCorrectCount;
import lotto.domain.generator.CustomLottoNumberGenerator;
import lotto.util.LottoUtils;
import lotto.view.Input;

import static java.util.Optional.of;
import static java.util.Optional.ofNullable;
import static lotto.domain.enums.LottoCorrectCount.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LottoMachineTest {

    @Test
    public void 금액에_맞는_개수인가() {
        LottoMachine lottoMachine = LottoMachine.init(Input.init("14000").getMoney());
        assertEquals(14, lottoMachine.getLottoCount());
    }

    @Test
    public void 입력된_개수에_맞는_로또가_생성되는가() {
        LottoMachine lottoMachine = LottoMachine.init(Input.init("14000").getMoney());
        assertEquals(14, lottoMachine.generateLottos().getLottos().size());
    }

    @Test
    public void 당첨번호_통계결과가_일치하는가() {
        Map<LottoCorrectCount, Integer> resultMap = initResultMap();

        assertEquals(of(2).get(), ofNullable(resultMap.get(THREE)).orElse(0));
        assertEquals(of(0).get(), ofNullable(resultMap.get(FOUR)).orElse(0));
        assertEquals(of(1).get(), ofNullable(resultMap.get(FIVE)).orElse(0));
        assertEquals(of(1).get(), ofNullable(resultMap.get(FIVE_DOUBLE)).orElse(0));
        assertEquals(of(1).get(), ofNullable(resultMap.get(SIX)).orElse(0));
    }

    @Test
    public void 총수익이_올바른가() {
        Map<LottoCorrectCount, Integer> resultMap = initResultMap();
        assertEquals(2031510000, LottoResults.getProfit(resultMap));
    }

    @Test
    public void 총수익률이_올바른가() {
        Map<LottoCorrectCount, Integer> resultMap = initResultMap();
        assertThat(LottoResults.getProfitRate(LottoResults.getProfit(resultMap), 6000), is(3.38585E7F));
    }

    private Map<LottoCorrectCount, Integer> initResultMap() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(Lotto.generate(() -> Arrays.stream(new int[]{1, 2, 3, 40, 41, 42}).boxed().collect(Collectors.toList()))); //THREE
        lottos.add(Lotto.generate(() -> Arrays.stream(new int[]{1, 2, 3, 14, 15, 16}).boxed().collect(Collectors.toList()))); //THREE
        lottos.add(Lotto.generate(() -> Arrays.stream(new int[]{1, 2, 3, 4, 5, 16}).boxed().collect(Collectors.toList()))); //FIVE
        lottos.add(Lotto.generate(() -> Arrays.stream(new int[]{11, 2, 7, 4, 5, 6}).boxed().collect(Collectors.toList()))); //FIVE_DOUBLE
        lottos.add(Lotto.generate(() -> Arrays.stream(new int[]{1, 2, 3, 4, 5, 6}).boxed().collect(Collectors.toList()))); //SIX

        List<Integer> winNumbers = Input.init("1, 2, 3, 4, 5, 6").winNumbers();
        WinningLotto.generate(winNumbers, 7);
        return LottoUtils.resultToMap(Lottos.generate(lottos).getLottos().stream().map(WinningLotto::match).collect(Collectors.toList()));
    }
}
