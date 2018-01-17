import domain.Lotto;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {
    Lotto lottos;

    @Before
    public void setup(){
        lottos = new Lotto();
    }
    @Test
    public void matchYn() {
        List<Integer> luckyNum = Arrays.asList(1,3,13,14,24,44);
        assertThat(lottos.matchYn(luckyNum,3)).isEqualTo(1);
    }
}
