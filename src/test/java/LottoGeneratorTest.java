import lottoGame.util.LottoGenerator;
import org.junit.Test;

public class LottoGeneratorTest {

    @Test(expected = IllegalArgumentException.class)
    public void 로또_가격보다_투자금이_낮을때() {
        LottoGenerator.lottoNum(900);
    }
}
