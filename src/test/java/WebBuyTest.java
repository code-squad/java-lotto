import lotto.WebBuy;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WebBuyTest {
    @Test
    public void 웹에서자동구매() {
        WebBuy buy = new WebBuy();
        int autoNum = buy.webAutoBuy(5).size();
        assertEquals(5, autoNum);
    }

    @Test
    public void 웹에서수동구매() {
        WebBuy buy = new WebBuy();
        List<String> manualNumber = new ArrayList<>();
        manualNumber.add("7,8,9,10,11,12");
        manualNumber.add("1,2,3,4,5,6");
        int manualCount = buy.webManualBuy(manualNumber).size();
        assertEquals(2, manualCount);
    }
}
