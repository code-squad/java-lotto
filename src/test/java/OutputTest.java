import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import lotto.view.Output;

import static org.junit.Assert.assertEquals;

public class OutputTest {

    @Test
    public void 생성된_로또들_출력형식이_올바른가() {
        assertEquals("[1,2,3,4,5,6]", Output.lottoNumbersFormatting(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }
}
