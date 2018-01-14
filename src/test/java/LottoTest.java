import org.junit.Test;

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
        assertEquals(LottoUtils.LOTTO_MAX_COUNT, Lotto.generate().getNumbers().length);
    }

    @Test
    public void 랜덤생성된_로또가_오름차순인가() {
        int[] numbers = Lotto.generate().getNumbers();
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
}
