import lotto.domain.WinningLotto;
import lotto.domain.enums.Rank;
import lotto.domain.generator.CustomLottoNumberGenerator;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Lotto;
import lotto.domain.generator.RandomLottoNumberGenerator;
import lotto.util.LottoUtils;

import static lotto.domain.enums.Rank.FIVE_DOUBLE;
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

    @Test
    public void 보너스볼을_받은_로또를_표시하는가() {
        List<Integer> winningLottos = Arrays.stream(new int[]{1, 2, 3, 40, 41, 42}).boxed().collect(Collectors.toList());
        List<Integer> testLottos = Arrays.stream(new int[]{1, 7, 6, 40, 41, 42}).boxed().collect(Collectors.toList());

        WinningLotto winningLotto = WinningLotto.generate(winningLottos, 7);
        Rank rank = winningLotto.match(Lotto.generate(new CustomLottoNumberGenerator(testLottos)));
        assertEquals(FIVE_DOUBLE, rank);
    }
}
