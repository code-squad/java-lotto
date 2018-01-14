import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumberGeneratorImpl;
import lotto.util.LottoUtils;
import lotto.view.Input;
import lotto.view.OutputView;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Optional.of;
import static lotto.domain.enums.LottoCorrectCount.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LottoTest {

    @Test(expected = IllegalArgumentException.class)
    public void 금액입력이_천원단위가_맞는가() {
        Input.init("14001").getMoney();
    }

    @Test
    public void 금액에_맞는_개수인가() {
        LottoMachine lottoMachine = LottoMachine.init(Input.init("14000").getMoney());
        assertEquals(14, lottoMachine.getLottoCount());
    }

    @Test
    public void 랜덤생성된_로또개수가_맞는가() {
        assertEquals(LottoUtils.LOTTO_MAX_COUNT, Lotto.generate(new LottoNumberGeneratorImpl()).getNumbers().length);
    }

    @Test
    public void 랜덤생성된_로또가_오름차순인가() {
        int[] numbers = Lotto.generate(new LottoNumberGeneratorImpl()).getNumbers();
        assertTrue(numbers[0] < numbers[1]);
        assertTrue(numbers[1] < numbers[2]);
        assertTrue(numbers[2] < numbers[3]);
        assertTrue(numbers[3] < numbers[4]);
    }

    @Test
    public void 입력된_개수에_맞는_로또가_생성되는가() {
        LottoMachine lottoMachine = LottoMachine.init(Input.init("14000").getMoney());
        assertEquals(14, lottoMachine.generateLottos().size());
    }

    @Test
    public void 생성된_로또들_출력형식이_올바른가() {
        assertEquals("[1, 2, 3, 4, 5, 6]", OutputView.lottoNumbersFormatting(new int[]{1, 2, 3, 4, 5, 6}));
    }

    @Test
    public void 당첨번호를_올바르게_입력받았는가() {
        List<Integer> winNumbers = Input.init("1, 2, 3, 4, 5, 6").winNumbers();
        assertEquals(of(1).get(), winNumbers.get(0));
        assertEquals(of(2).get(), winNumbers.get(1));
        assertEquals(of(3).get(), winNumbers.get(2));
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
