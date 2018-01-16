import lotto.Lotto;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class LottoTest {

    private Lotto lotto = new Lotto();

    @Test
    public void generateLotto(){
        assertThat(lotto.generateNumber().size()).isEqualTo(6);
    }

    @Test
    public void compareResult(){
        List<Integer> result = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(lotto.compare(result)).isBetween(0, 6);
    }
}
