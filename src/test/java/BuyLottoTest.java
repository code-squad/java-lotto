import lotto.BuyLotto;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BuyLottoTest {
    @Test
    public void 로또구매() {
        int inputMoney = 14000;
        BuyLotto buy = new BuyLotto(inputMoney);
        int num = buy.getLottos().size();
        assertEquals(14, num);
    }
}
