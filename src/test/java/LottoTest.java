import org.junit.Test;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.lottogenerator.RandomLottoNumberGenerator;
import lotto.util.LottoUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LottoTest {

    @Test
    public void 랜덤생성된_로또개수가_맞는가() {
        assertEquals(LottoUtils.LOTTO_MAX_COUNT, Lotto.generate(new RandomLottoNumberGenerator()).getNumbers().size());
    }

    @Test
    public void 랜덤생성된_로또가_오름차순인가() {
        List<Integer> numbers = Lotto.generate(new RandomLottoNumberGenerator()).getNumbers();
        assertTrue(numbers.get(0) < numbers.get(1));
        assertTrue(numbers.get(1) < numbers.get(2));
        assertTrue(numbers.get(2) < numbers.get(3));
        assertTrue(numbers.get(3) < numbers.get(4));
    }

}
