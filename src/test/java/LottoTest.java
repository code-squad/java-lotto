import lotto.Lotto;
import model.RandomNumber;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class LottoTest {

    private Lotto lotto = new Lotto(RandomNumber.shuffleNumber());

    @Test
    public void compareResult(){
        List<Integer> result = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(lotto.compare(result)).isBetween(0, 6);
    }
}
