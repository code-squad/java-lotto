import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domain.Lotto;
import lotto.domain.generator.CustomLottoNumberGenerator;
import lotto.view.Input;

import static java.util.Optional.of;
import static org.junit.Assert.assertEquals;

public class InputTest {

    @Test(expected = IllegalArgumentException.class)
    public void 금액입력이_천원단위가_맞는가() {
        Input.init("14001").getMoney();
    }

    @Test
    public void 당첨번호를_올바르게_입력받았는가() {
        List<Integer> winNumbers = Input.init("1, 2, 3, 4, 5, 6").winNumbers().getNumbers();
        assertEquals(of(1).get(), winNumbers.get(0));
        assertEquals(of(2).get(), winNumbers.get(1));
        assertEquals(of(3).get(), winNumbers.get(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 중복된_보너스_값을_입력받았을때_에러를_발생시키는가() {
        Input input = Input.init("1");
        input.getBonusBall(Lotto.generate(new CustomLottoNumberGenerator(IntStream.range(1, 6).boxed().collect(Collectors.toList()))));
    }

    @Test
    public void 수동으로_입력받은_로또_올바른가() {
        assertEquals(3, Input.init("3").customLottoCount());
    }

    @Test
    public void 수동으로_입력받은_로또_번호가_올바른가() {
        List<Lotto> customLottos = Input.init("1, 2, 3, 4, 5, 6\n7, 8, 9, 10, 11, 12").customLottoms(2);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(Lotto.generate(new CustomLottoNumberGenerator(Arrays.asList(1, 2, 3, 4, 5, 6))));
        lottos.add(Lotto.generate(new CustomLottoNumberGenerator(Arrays.asList(7, 8, 9, 10, 11, 12))));

        assertEquals(lottos, customLottos);
    }
}
