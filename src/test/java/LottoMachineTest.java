import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.util.LottoUtils;
import lotto.view.Input;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Optional.of;
import static lotto.domain.enums.LottoCorrectCount.FOUR;
import static lotto.domain.enums.LottoCorrectCount.SIX;
import static lotto.domain.enums.LottoCorrectCount.THREE;
import static org.junit.Assert.assertEquals;

public class LottoMachineTest {

    @Test
    public void 금액에_맞는_개수인가() {
        LottoMachine lottoMachine = LottoMachine.init(Input.init("14000").getMoney());
        assertEquals(14, lottoMachine.getLottoCount());
    }

    @Test
    public void 입력된_개수에_맞는_로또가_생성되는가() {
        LottoMachine lottoMachine = LottoMachine.init(Input.init("14000").getMoney());
        assertEquals(14, lottoMachine.generateLottos().size());
    }

    @Test
    public void 당첨번호_통계결과가_일치하는가() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(Lotto.generate(() -> new int[]{1, 2, 3, 40, 41, 42})); //THREE
        lottos.add(Lotto.generate(() -> new int[]{10, 20, 30, 4, 5, 6})); //THREE
        lottos.add(Lotto.generate(() -> new int[]{10, 2, 3, 4, 15, 16})); //THREE
        lottos.add(Lotto.generate(() -> new int[]{1, 2, 3, 4, 15, 16})); //FOUR
        lottos.add(Lotto.generate(() -> new int[]{11, 20, 3, 4, 5, 6})); //FOUR
        lottos.add(Lotto.generate(() -> new int[]{1, 2, 3, 4, 5, 6})); //SIX

        List<Integer> winNumbers = Input.init("1, 2, 3, 4, 5, 6").winNumbers();
        Map<String, Integer> result = LottoUtils.resultToMap(LottoMachine.getLottoResults(lottos, winNumbers));

        assertEquals(of(3).get(), result.get(THREE.name()));
        assertEquals(of(2).get(), result.get(FOUR.name()));
        assertEquals(of(1).get(), result.get(SIX.name()));
    }
}
