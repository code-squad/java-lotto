import lotto.domain.Lotto;
import lotto.domain.LottoNumberGeneratorImpl;
import lotto.util.LottoUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LottoTest {

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

}
