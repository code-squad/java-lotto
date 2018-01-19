import lottoGame.util.LottoGenerator;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LottoGeneratorTest {

    @Test(expected = IllegalArgumentException.class)
    public void 로또_가격보다_투자금이_낮을때() {
        LottoGenerator.lottoNum(900);
    }

    @Test
    public void 로또_개수_테스트() {
       assertEquals(5,LottoGenerator.lottoNum(5000));
    }
}
